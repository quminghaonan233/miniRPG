package battle;

import java.util.List;

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
			slime.getStateList()[0].setLastTime(1);
			slime.getStateList()[0].setDamage(3);
		}else if(controlNum == 1) {
			
		}else if(controlNum == 2) {
			
		}else if(controlNum == 3) {
			
		}else if(controlNum == 4) {
			
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
	
	//userÖÐ¶¾
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
	
	//slimeÖÐ¶¾
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
	
	//slimeÑ£ÔÎ
	public boolean isSlimeInVertigo(Slime slime) {
		if (slime.getStateList()[3].getLastTime()>=1) {
			return true;
		}
		return false;
	}
	
	public void slimeInVertigoInvoker(Slime slime) {
		slime.getStateList()[3].setLastTime(slime.getStateList()[3].getLastTime()-1);
	}
	
	//slimeÑ£ÔÎ
	public boolean isSlimeInSilence(Slime slime) {
		if (slime.getStateList()[2].getLastTime()>=1) {
			return true;
		}
		return false;
	}
	
	public void slimeInSilenceInvoker(Slime slime) {
		slime.getStateList()[2].setLastTime(slime.getStateList()[2].getLastTime()-1);
	}
}
