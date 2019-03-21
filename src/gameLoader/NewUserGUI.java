package gameLoader;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.attribute.UserPrincipalNotFoundException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import user.RoleType;
import user.User;

public class NewUserGUI {
	
	//界面大小
	private final static int GUIWidth = 1200;
	private final static int GUIHeight = 800;
	
	private final static int LabelStartx = 200;
	
	private final static Font LableFont = new Font("宋体", Font.BOLD, 20);
	private final static int ButtonBounds = 100;
	private final static int ButtonHeight = 200;
	private final static int ButtonStarty = 270;
	private final static int RoleTypeLength = RoleType.values().length;
	private final static int roleButtonWidth = ((GUIWidth - 2 * LabelStartx) - (RoleTypeLength - 1) * ButtonBounds)/RoleTypeLength;

	private static int roleSelect  = 0;
	private JTextField userNameText;
	private JLabel userNameMessage;
	
	private JButton [] roleButtonList;
	
	public void createNewUser() {
	    JFrame frame = new JFrame("choose a role");
	    
	    frame.setSize(GUIWidth, GUIHeight);
	    frame.setLocationRelativeTo(null);

	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    JPanel panel = new JPanel();    

	    panel.setLayout(null);
	    
	    JLabel userNameLabel = new JLabel("角色名称");
	    userNameLabel.setBounds(LabelStartx,150,180,40);
	    userNameLabel.setFont(LableFont);
	    panel.add(userNameLabel);
	    
	    userNameText = new JTextField(40);
	    userNameText.setBounds(340,150,180,40);
	    panel.add(userNameText);
	    
	    userNameMessage = new JLabel("请输入角色名称");
	    userNameMessage.setForeground(Color.RED);
	    userNameMessage.setBounds(600,150,180,40);
	    userNameMessage.setVisible(false);
	    panel.add(userNameMessage);
	    
	    JLabel roleLabel = new JLabel("角色类型");
	    roleLabel.setBounds(LabelStartx,200,180,40);
	    roleLabel.setFont(LableFont);
	    panel.add(roleLabel);
	    
	    roleButtonList = new JButton[RoleTypeLength];
	    
	    int startx = LabelStartx;
	    for (int i = 0; i < RoleTypeLength; i++) {
	    	JButton button = new JButton(RoleType.getDescription(i));
	    	button.setBounds(startx,ButtonStarty,roleButtonWidth,ButtonHeight);
	    	if(i != 0) {
	    		button.setBorderPainted(false);
	    	}
	    	button.addActionListener(new roleChooseListener(button));
	    	roleButtonList[i] = button;
	    	panel.add(button);
	    	startx = startx + roleButtonWidth + ButtonBounds;
	    }
	    
	    JButton submitButton = new JButton("完成");
	    submitButton.setBounds(550,500,100,40);
	    submitButton.addActionListener(new roleSubmitListener());
	    panel.add(submitButton);
	    
	    frame.add(panel);
	    frame.setVisible(true);
	}
	
	public class roleSubmitListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String userName = userNameText.getText();
			if(userName == null || userName.equals("")) {
				userNameMessage.setVisible(true);
			}
			else {
				User u = RoleType.getUserFactoryById(roleSelect).createUser(userName);
				GameMap m = new GameMap();
				GameInitializer gameInitializer = new GameInitializer(u, m); 
				gameInitializer.initializeGame();
			}
			
		}
		
	}
	
	public class roleChooseListener implements ActionListener{		
		private JButton button;
		
		public roleChooseListener(JButton button) {
			this.button = button;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			roleSelect = RoleType.getId(e.getActionCommand());
			for(JButton b:roleButtonList) {
				b.setBorderPainted(false);
			}
			button.setBorderPainted(true);
		}
	}
	
}
