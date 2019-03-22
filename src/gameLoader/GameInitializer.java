package gameLoader;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import MapLabel.EmptyLabel;
import slime.Slime;
import slime.SlimeType;
import user.RoleType;
import user.User;

public class GameInitializer {

	private static String emptyImageIconPath = System.getProperty("user.dir") + "/resource/img/empty.png";
	private static String mixImageIconPath = System.getProperty("user.dir") + "/resource/img/mixSlime.png";
	private static String startIconPath = System.getProperty("user.dir") + "/resource/img/startPoint.jpg";
	private static String endIconPath = System.getProperty("user.dir") + "/resource/img/endPoint.png";
	
	private final static int GUIWidth = 1200;
	private final static int GUIHeight = 800;
	private final static int startX = 20;
	private final static int startY = 20;
	private final static int endX = 708;
	private final static int endY = 708;
	private final static int imageWidth = (endX-startX)/GameMap.xSize;
	private final static int imageHeight = (endY-startY)/GameMap.ySize;
	private final static int AvatorLength = 80;
	
	private User user;
	private GameMap gameMap;
	private int userX;
	private int userY;
	
	private JFrame frame;
	private JPanel mapPanel;
	private JPanel userPanel;
	
	private JLabel[][] labelList;
	private String [][] iconPathList;
	
	public GameInitializer(User u,GameMap m) {
		this.user = u;
		this.gameMap = m;
		this.userX = m.getStartX();
		this.userY = m.getStartY();
		
	    frame = new KeyBoardFrame("miniRPG");
	    
	    frame.setSize(GUIWidth, GUIHeight);
	    frame.setLocationRelativeTo(null);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	    frame.setLayout(null);
		mapPanel = new JPanel(); 
		frame.add(mapPanel);
        
		userPanel = new JPanel();
//		userPanel.setBackground(Color.RED);
//		userPanel.setOpaque(true);

		frame.add(userPanel);
		frame.setVisible(true);

	}
	
	private void placeMapPanel() { 
		System.out.println("startPlaceComponent");
  
		mapPanel.removeAll();
		mapPanel.setBounds(0,0,800,800);
		mapPanel.setLayout(null);

		labelList = new JLabel[GameMap.xSize][GameMap.ySize];
		iconPathList = new String[GameMap.xSize][GameMap.ySize];
		EmptyLabel l = new EmptyLabel();
		for(int i = 0 ;i<GameMap.xSize;i++) {
			for(int j = 0; j<GameMap.ySize;j++) {
				JLabel temp = l.clone();
				int x1 = startX + i * (endX-startX)/GameMap.xSize;
				int y1 = startY + j * (endY-startY)/GameMap.ySize;
				temp.setBounds(x1,y1,imageWidth,imageHeight);
				temp.setBorder(BorderFactory.createLineBorder(Color.GRAY));
				labelList[i][j] = temp;
				iconPathList[i][j] = emptyImageIconPath;
				mapPanel.add(temp);
			}
		}

	}
	
	private void placeUserPanel() {
		userPanel.removeAll();
		userPanel.setBounds(800, 0, 400, 800);
		userPanel.setLayout(null);

		ImageIcon userAvator = new ImageIcon(user.getImagePath());
		userAvator.setImage(userAvator.getImage().getScaledInstance(AvatorLength,AvatorLength,Image.SCALE_DEFAULT));
		JLabel userAvatorLabel = new JLabel();
		userAvatorLabel.setIcon(userAvator);
		userAvatorLabel.setBounds(20, 20, 80, 80);
		userPanel.add(userAvatorLabel);
		
		JLabel userNameLabel = new JLabel("角色名: "+ user.getUserName());
		userNameLabel.setBounds(120,20,100,20);
		userPanel.add(userNameLabel);
		
		JLabel userRoleTypeLabel = new JLabel("职业: "+ RoleType.getDescription(user.getRoleType()));
		userRoleTypeLabel.setBounds(120,50,100,20);
		userPanel.add(userRoleTypeLabel);
		
		JLabel userLevelLabel = new JLabel("角色等级: "+ user.getLV());
		userLevelLabel.setBounds(120,80,100,20);
		userPanel.add(userLevelLabel);
		
//		JLabel userHPLabel = new JLabel("生命值: "+ user.getCurrent_HP() + "/" + user.getHPDecroted());
//		userHPLabel.setBounds(220,20,100,20);
//		userPanel.add(userHPLabel);
//		
//		JLabel userMPLabel = new JLabel("魔法值: "+ user.getCurrent_MP() + "/" + user.getMPDecroted());
//		userMPLabel.setBounds(220,50,100,20);
//		userPanel.add(userMPLabel);
//		
//		JLabel userExpLabel = new JLabel("经验: "+ user.getEXP() + "/100");
//		userExpLabel.setBounds(220,80,100,20);
//		userPanel.add(userExpLabel);
		
		
		

	}
	
	
	public void initializeGame() {
		refresh();
	}
	
	public void refresh() {
		placeMapPanel();
		placeUserPanel();
		refreshStartEndPoint();
		refreshSlime();
		refreshUser();
		mapPanel.repaint();
		nextLevelTrigger();
		FightTrigger();
	}
	
	private void refreshStartEndPoint() {
		iconPathList[gameMap.getStartX()][gameMap.getStartY()] = startIconPath;
		iconPathList[gameMap.getEndX()][gameMap.getEndY()] = endIconPath;	
	}
	
	
	private void refreshUser() {
		System.out.println("startrefreshUser");

		ImageIcon userIcon = new ImageIcon(user.getImagePath());
		userIcon.setImage(userIcon.getImage().getScaledInstance(imageWidth,imageHeight,Image.SCALE_DEFAULT));
		labelList[userX][userY].setIcon(userIcon);
	}
	
	private void nextLevelTrigger() {
		if(userX == gameMap.getEndX() && userY == gameMap.getEndY()) {
			this.gameMap = new GameMap(gameMap.getLevel() + 1);
			this.userX = 0;
			this.userY = 0;
			refresh();
		}
	}
	
	private void FightTrigger() {
		ArrayList<Slime> fightSlime = new ArrayList<Slime>();
		System.out.println(gameMap.getSlimeList().size());
		for(Slime s:gameMap.getSlimeList()) {
			if(s.getPosX() == userX && s.getPosY() == userY) {
				fightSlime.add(s);
			}
		}
		for(Slime s:fightSlime) {
			gameMap.getSlimeList().remove(s);
		}
		System.out.println(gameMap.getSlimeList().size());
		if(fightSlime.size() > 0) {
			//jump to fight
			System.out.println("触发战斗");
		}
		
	}
	
	private void refreshSlime() {
		System.out.println("startrefreshSlime");
		for(Slime s:gameMap.getSlimeList()) {
			if(iconPathList[s.getPosX()][s.getPosY()] .equals(emptyImageIconPath)) {
				iconPathList[s.getPosX()][s.getPosY()] = s.getImagePath();
			}
			else {
				if(!iconPathList[s.getPosX()][s.getPosY()].equals(s.getImagePath())) {
					iconPathList[s.getPosX()][s.getPosY()] = mixImageIconPath;
				}
			}
		}
		for(int i = 0 ;i<GameMap.xSize;i++) {
			for(int j = 0; j<GameMap.ySize;j++) {
				ImageIcon icon = new ImageIcon(iconPathList[i][j]);
				icon.setImage(icon.getImage().getScaledInstance(imageWidth,imageHeight,Image.SCALE_DEFAULT));
				labelList[i][j].setIcon(icon);
			}
		}
	}
	
	
	public void slimeMove() {
		ArrayList<Slime> slimeList = gameMap.getSlimeList();
		for(Slime s:slimeList) {
			s.move(userX, userY);
		}
	}
	
	public class KeyBoardFrame extends JFrame {

		public KeyBoardFrame(String string) {
			super(string);
			this.addKeyListener(new KeyBoardListener());
		}


		class KeyBoardListener implements KeyListener{
			@Override
			public void keyTyped(KeyEvent e) {
//				System.out.println("输入：" + e.getKeyChar() + "\n");		
			}

			@Override
			public void keyPressed(KeyEvent e) {
				boolean changed = false;
				switch(KeyEvent.getKeyText(e.getKeyCode())){
					case("W"):
						if(userY > 0) {
							userY--;
							changed = true;
						}
						break;
					case("A"):
						if(userX > 0) {
							userX--;
							changed = true;
						}
						break;
					case("S"):
						if(userY < GameMap.ySize - 1) {
							userY++;
							changed = true;
						}
						break;
					case("D"):
						if(userX < GameMap.xSize - 1) {
							userX++;
							changed = true;
						}
						break;
					default:
						break;
				}
				
				if(changed) {
					slimeMove();
					refresh();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
//				System.out.println("松开："+KeyEvent.getKeyText(e.getKeyCode()) + "\n");
				
			}

		}
	}
}
