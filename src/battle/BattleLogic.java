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
