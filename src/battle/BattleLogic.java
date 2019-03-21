package battle;

import slime.Slime;
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
		
	}
	
	public void waitPro() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
