package gameLoader;

public class GameInitializer {
	private static GameInitializer gameLoader;
	
	private GameInitializer() {
		
	}
	
	public static GameInitializer getInstance() {
		if(gameLoader == null) {
			gameLoader = new GameInitializer();
		}
		return gameLoader;
	}
	
	public void initializeGame(User u,GameMap m) {
		
	}
}
