package battle;

import java.util.List;

import skill.Skill;
import skill.activeSkill;
import skill.passiveSkill;
import slime.Slime;
import state.StateType;
import user.User;

public class BattleLogic {
	private static BattleLogic bl;

	private BattleLogic() {
		
	}
	
	public static BattleLogic getInstance() {
		if(bl == null) {
			bl = new BattleLogic();
		}
		return bl;
	}
	
	public void userATK(User user, Slime slime, int controlNum) {
		if(controlNum == 0) {
			user.attack(slime);
		}else{
			activeSkill s = (activeSkill)user.getSkillList()[controlNum-1];
			s.useSkill(user, slime);
		}
	}
	
	public void enemyATK(Slime slime,User user) {
		slime.attack(user);
	}
	
	public void waitPro(int i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean isSuccess(List<Slime> slimeList) {
		for (int i=0;i<slimeList.size();i++) {
			if (slimeList.get(i).isAlive()) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isFailure(User user) {
		if(user.isAlive()) {
			return false;
		}
		return true;
	}
	
	//user中毒
	public boolean isUserInPoison(User user) {
		if (user.getPoison().getLastTime()>=1) {
			return true;
		}
		return false;
	}
	
	public void userInPoisonInvoker(User user) {
		user.getPoison().setLastTime(user.getPoison().getLastTime()-1);
		double current_HP = user.getCurrent_HP()-user.getPoison().getDamage();
		user.setCurrent_HP(current_HP>0?current_HP:0);
	}
	
	//slime中毒
	public boolean isSlimeInPoison(Slime slime) {
		if (slime.getStateList()[0].getLastTime()>=1) {
			return true;
		}
		return false;
	}
	
	public void slimeInPoisonInvoker(Slime slime) {
		slime.getStateList()[0].setLastTime(slime.getStateList()[0].getLastTime()-1);
		double current_HP = slime.getCurrent_HP()-slime.getStateList()[0].getDamage();
		slime.setCurrent_HP(current_HP>0?current_HP:0);
	}
	
	//slime眩晕
	public boolean isSlimeInVertigo(Slime slime) {
		if (slime.getStateList()[2].getLastTime()>=1) {
			return true;
		}
		return false;
	}
	
	public void slimeInVertigoInvoker(Slime slime) {
		slime.getStateList()[2].setLastTime(slime.getStateList()[2].getLastTime()-1);
	}
	
	//slime眩晕
	public boolean isSlimeInSilence(Slime slime) {
		if (slime.getStateList()[1].getLastTime()>=1) {
			return true;
		}
		return false;
	}
	
	public void slimeInSilenceInvoker(Slime slime) {
		slime.getStateList()[1].setLastTime(slime.getStateList()[1].getLastTime()-1);
	}
	
	//判断技能种类
	public int judgeSkillType(Skill s) {
		if (s instanceof passiveSkill) {
			return 0;
		}else {
			activeSkill temp = (activeSkill)s;
			if(temp.isDamageSkill()) {
				return 2;
			}else {
				return 1;
			}
		}
	}
	
	//user技能冷却处理
	public void userSkillColdTimeInvoker(User user) {
		for (Skill s:user.getSkillList()) {
			if (s instanceof activeSkill) {
				activeSkill temp = (activeSkill)s;
				if(temp.getColdTime()>=1) {
					temp.setColdTime(temp.getColdTime()-1);
				}
			}
		}
	}
	
	//user技能刷新
	public void userSkillUpdate(User user) {
		for(Skill s:user.getSkillList()) {
			if(s instanceof activeSkill) {
				activeSkill temp = (activeSkill)s;
				temp.setColdTime(0);
			}
		}
	}
	
	//用户技能升级
	public void userSkillUp(User user, int lv) {
		if(lv == 1) {
			user.getSkillList()[0].setSkillLevel(1);
			user.getSkillList()[1].setSkillLevel(0);
			user.getSkillList()[2].setSkillLevel(0);
			user.getSkillList()[3].setSkillLevel(0);
		}else if(lv == 2) {
			user.getSkillList()[0].setSkillLevel(1);
			user.getSkillList()[1].setSkillLevel(1);
			user.getSkillList()[2].setSkillLevel(0);
			user.getSkillList()[3].setSkillLevel(0);
		}else if(lv == 3) {
			user.getSkillList()[0].setSkillLevel(1);
			user.getSkillList()[1].setSkillLevel(1);
			user.getSkillList()[2].setSkillLevel(1);
			user.getSkillList()[3].setSkillLevel(0);
		}else if(lv == 4) {
			user.getSkillList()[0].setSkillLevel(1);
			user.getSkillList()[1].setSkillLevel(1);
			user.getSkillList()[2].setSkillLevel(1);
			user.getSkillList()[3].setSkillLevel(1);
		}else if(lv == 5) {
			user.getSkillList()[0].setSkillLevel(2);
			user.getSkillList()[1].setSkillLevel(1);
			user.getSkillList()[2].setSkillLevel(1);
			user.getSkillList()[3].setSkillLevel(1);
		}else if(lv == 6) {
			user.getSkillList()[0].setSkillLevel(2);
			user.getSkillList()[1].setSkillLevel(2);
			user.getSkillList()[2].setSkillLevel(1);
			user.getSkillList()[3].setSkillLevel(1);
		}else if(lv == 7) {
			user.getSkillList()[0].setSkillLevel(2);
			user.getSkillList()[1].setSkillLevel(2);
			user.getSkillList()[2].setSkillLevel(2);
			user.getSkillList()[3].setSkillLevel(1);
		}else if(lv == 8) {
			user.getSkillList()[0].setSkillLevel(2);
			user.getSkillList()[1].setSkillLevel(2);
			user.getSkillList()[2].setSkillLevel(2);
			user.getSkillList()[3].setSkillLevel(2);
		}else if(lv == 9) {
			user.getSkillList()[0].setSkillLevel(3);
			user.getSkillList()[1].setSkillLevel(2);
			user.getSkillList()[2].setSkillLevel(2);
			user.getSkillList()[3].setSkillLevel(2);
		}else if(lv == 10) {
			user.getSkillList()[0].setSkillLevel(3);
			user.getSkillList()[1].setSkillLevel(3);
			user.getSkillList()[2].setSkillLevel(2);
			user.getSkillList()[3].setSkillLevel(2);
		}else {
			user.getSkillList()[0].setSkillLevel(3);
			user.getSkillList()[1].setSkillLevel(3);
			user.getSkillList()[2].setSkillLevel(3);
			user.getSkillList()[3].setSkillLevel(2);
		}
	}
}
