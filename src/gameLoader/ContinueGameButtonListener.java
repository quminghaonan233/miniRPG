package gameLoader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import user.User;

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
		User u = gameLoader.loadUser();
		Configure config = gameLoader.load(Configure.class);
		GameMap m  = new GameMap(config.getLevel());
		
		GameInitializer gameInitializer = new GameInitializer(u,m,config); 
		gameInitializer.initializeGame();
	}
}
