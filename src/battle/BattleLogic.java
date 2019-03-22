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
		}else if(controlNum == 1) {
			
		}else if(controlNum == 2) {
			
		}else if(controlNum == 3) {
			
		}else if(controlNum == 4) {
			
		}
	}
	
	public void enemyATK(Slime slime,User user) {
		slime.attack(user);
		user.getState().setLastTime(1);
		user.getState().setDamage(12);
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
	
	public boolean isUserInPoison(User user) {
		if (user.getState().getLastTime()>=1) {
			return true;
		}
		return false;
	}
	
	public void userInPoisonHandler(User user) {
		user.getState().setLastTime(user.getState().getLastTime()-1);
		user.setCurrent_HP(user.getCurrent_HP()-user.getState().getDamage());
	}
}
