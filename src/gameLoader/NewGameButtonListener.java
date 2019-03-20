package gameLoader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class NewGameButtonListener implements ActionListener{
	private JFrame oldFrame;
	
	public NewGameButtonListener(JFrame oldFrame) {
		this.oldFrame = oldFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.oldFrame.dispose();
		new NewUserGUI().createNewUser();
	}
}
