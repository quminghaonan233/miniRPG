package gameLoader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class ContinueGameButtonListener implements ActionListener{
	private JFrame oldFrame;
	
	public ContinueGameButtonListener(JFrame oldFrame) {
		this.oldFrame = oldFrame;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.oldFrame.dispose();
		loadAndInitialize();
	}
	
	private void loadAndInitialize() {
		GameLoader gameLoader = GameLoader.getInstance();
		User u = gameLoader.load(User.class);
		GameMap m  = gameLoader.load(GameMap.class);
		
		GameInitializer gameInitializer = GameInitializer.getInstance(); 
		gameInitializer.initializeGame(u,m);
	}
}
