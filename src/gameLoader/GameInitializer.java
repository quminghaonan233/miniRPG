package gameLoader;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import Medicine.Medicine;
import battle.BattleHandler;
import slime.Slime;
import slime.SlimeType;
import user.RoleType;
import user.User;
import weapon.Armor;
import weapon.Ornament;
import weapon.Weapon;
import weapon.equip;

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
	
	private final static int packagestartx = 20;
	private final static int packagestarty = 300;
	
	private User user;
	private GameMap gameMap;
	private int userX;
	private int userY;
	
	private int equipSelect = -1;
	private int packageSelect = -1;
	
	private JButton dropButton;
	private JButton equipButton;
	private JButton useButton;
	private JButton saveButton;
	
	private JFrame frame;
	private JPanel mapPanel;
	private JPanel userPanel;
	
	private Configure config;
	
	private JLabel[][] labelList;
	private String [][] iconPathList;
	
	public GameInitializer(User u,GameMap m,Configure config) {
		this.user = u;
		this.gameMap = m;
		this.userX = m.getStartX();
		this.userY = m.getStartY();
		this.config = config;
		
	    frame = new KeyBoardFrame("miniRPG");
	    
	    frame.setSize(GUIWidth, GUIHeight);
	    frame.setLocationRelativeTo(null);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	    frame.setLayout(null);
		mapPanel = new JPanel(); 
		frame.add(mapPanel);
        
		userPanel = new JPanel();

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
		
		JLabel mapLevelLabel = new JLabel("当前关卡: "+ gameMap.getLevel());
		mapLevelLabel.setBounds(20,20,200,20);
		mapLevelLabel.setFont(new Font("仿宋", Font.PLAIN, 20));
		userPanel.add(mapLevelLabel);

		ImageIcon userAvator = new ImageIcon(user.getImagePath());
		userAvator.setImage(userAvator.getImage().getScaledInstance(AvatorLength,AvatorLength,Image.SCALE_DEFAULT));
		JLabel userAvatorLabel = new JLabel();
		userAvatorLabel.setIcon(userAvator);
		userAvatorLabel.setBounds(20, 50, 80, 80);
		userPanel.add(userAvatorLabel);
		
		JLabel userNameLabel = new JLabel("角色名: "+ user.getUserName());
		userNameLabel.setBounds(120,50,100,20);
		userPanel.add(userNameLabel);
		
		JLabel userRoleTypeLabel = new JLabel("职业: "+ RoleType.getDescription(user.getRoleType()));
		userRoleTypeLabel.setBounds(120,80,100,20);
		userPanel.add(userRoleTypeLabel);
		
		JLabel userLevelLabel = new JLabel("角色等级: "+ user.getLV());
		userLevelLabel.setBounds(120,110,100,20);
		userPanel.add(userLevelLabel);
		
		JLabel userHPLabel = new JLabel("生命值: "+ (int)user.getCurrent_HP() + "/" + (int)user.getHPDecroted());
		userHPLabel.setBounds(220,50,100,20);
		userPanel.add(userHPLabel);
		
		JLabel userMPLabel = new JLabel("魔法值: "+ (int)user.getCurrent_MP() + "/" + (int)user.getMPDecroted());
		userMPLabel.setBounds(220,80,100,20);
		userPanel.add(userMPLabel);
		
		JLabel userExpLabel = new JLabel("经验: "+ (int)user.getEXP() + "/100");
		userExpLabel.setBounds(220,110,100,20);
		userPanel.add(userExpLabel);
		
		JLabel weaponLabel = new JLabel("武器");
		weaponLabel.setBounds(40,150,60,20);
		userPanel.add(weaponLabel);
		
		JLabel armorLabel = new JLabel("防具");
		armorLabel.setBounds(140,150,60,20);
		userPanel.add(armorLabel);
		
		JLabel ornamentLabel = new JLabel("饰品");
		ornamentLabel.setBounds(240,150,60,20);
		userPanel.add(ornamentLabel);
		
		JButton weaponButton = new JButton();
		ImageIcon weaponIcon = new ImageIcon(getEquipImage(0));
		weaponIcon.setImage(weaponIcon.getImage().getScaledInstance(AvatorLength,AvatorLength,Image.SCALE_DEFAULT));
		weaponButton.setIcon(weaponIcon);
		weaponButton.setBounds(20,170,80,80);
		weaponButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setButtonDisable();
				if(getEquip(0) != null) {
					equipSelect = 0;
					packageSelect = -1;
					showDropOption();
					frame.requestFocus();
				}
					
			}
		});
		userPanel.add(weaponButton);
		
		JButton armorButton = new JButton();
		ImageIcon armorIcon = new ImageIcon(getEquipImage(1));
		armorIcon.setImage(armorIcon.getImage().getScaledInstance(AvatorLength,AvatorLength,Image.SCALE_DEFAULT));
		armorButton.setIcon(armorIcon);
		armorButton.setBounds(120,170,80,80);
		armorButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setButtonDisable();
				if(getEquip(1) != null) {
					equipSelect = 1;
					packageSelect = -1;
					showDropOption();
					frame.requestFocus();
				}
			}
		});
		userPanel.add(armorButton);
		
		JButton ornamentButton = new JButton();
		ImageIcon ornamentIcon = new ImageIcon(getEquipImage(2));
		ornamentIcon.setImage(ornamentIcon.getImage().getScaledInstance(AvatorLength,AvatorLength,Image.SCALE_DEFAULT));
		ornamentButton.setIcon(ornamentIcon);
		ornamentButton.setBounds(220,170,80,80);
		ornamentButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setButtonDisable();
				if(getEquip(2) != null) {
					equipSelect = 2;
					packageSelect = -1;
					showDropOption();
					frame.requestFocus();
				}

			}
		});
		userPanel.add(ornamentButton);
		
		JLabel packageLabel = new JLabel("背包");
		packageLabel.setBounds(20,280,60,20);
		userPanel.add(packageLabel);
		
		
		for(int i = 0;i < 9;i++) {
			JButton tempButton = new JButton();
			String path = "";
			if(user.getPackageList().size() > i) {
				path = user.getPackageList().get(i).getImagePath();
			}
			ImageIcon packageIcon = new ImageIcon(path);
			packageIcon.setImage(packageIcon.getImage().getScaledInstance(AvatorLength,AvatorLength,Image.SCALE_DEFAULT));
			tempButton.setIcon(packageIcon);
			tempButton.setBounds(packagestartx + i%3 * AvatorLength,packagestarty+(int)(i/3)*AvatorLength,AvatorLength,AvatorLength);
			tempButton.addActionListener(new PackageButtonListener(i));
			userPanel.add(tempButton);
		}
		
		dropButton = new JButton("移除");
		dropButton.setBounds(20, 600, 80, 40);
		dropButton.setEnabled(false);
		dropButton.addActionListener(new DropButtonActionListener());
		userPanel.add(dropButton);
		
		equipButton = new JButton("装备");
		equipButton.setBounds(120, 600, 80, 40);
		equipButton.setEnabled(false);
		equipButton.addActionListener(new EquipButtonActionListener());
		userPanel.add(equipButton);
		
		useButton = new JButton("使用");
		useButton.setBounds(220, 600, 80, 40);
		useButton.setEnabled(false);
		useButton.addActionListener(new UseButtonActionListener());
		userPanel.add(useButton);
		
		saveButton = new JButton("保存");
		saveButton.setBounds(50, 680, 80, 40);
		saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				saveToFile();
				frame.requestFocus();
			}
		});
		userPanel.add(saveButton);
		

	}
	
	private void saveToFile() {
		GameLoader.getInstance().save(user);
		GameLoader.getInstance().save(config);
		
	}
	
	public String getEquipImage(int equipType){
		if(user.getEquipList().size()>0) {
			if(equipType == 0) {
				for(equip e:user.getEquipList()) {
					if(e instanceof Weapon) {
						return e.getImagePath();
					}
				}
			}
			else if(equipType == 1) {
				for(equip e:user.getEquipList()) {
					if(e instanceof Armor) {
						return e.getImagePath();
					}
				}
			}
			else if(equipType == 2){
				for(equip e:user.getEquipList()) {
					if(e instanceof Ornament) {
						return e.getImagePath();
					}
				}
			}
		}
		return "";
	}
	
	public equip getEquip(int equipType){
		if(user.getEquipList().size()>0) {
			if(equipType == 0) {
				for(equip e:user.getEquipList()) {
					if(e instanceof Weapon) {
						return e;
					}
				}
			}
			else if(equipType == 1) {
				for(equip e:user.getEquipList()) {
					if(e instanceof Armor) {
						return e;
					}
				}
			}
			else if(equipType == 2){
				for(equip e:user.getEquipList()) {
					if(e instanceof Ornament) {
						return e;
					}
				}
			}
		}
		return null;
	}
	
	public void showEquipOption() {
		equipButton.setEnabled(true);
	}
	
	public void showDropOption() {
		dropButton.setEnabled(true);
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
		userPanel.repaint();
		setButtonDisable();
		nextLevelTrigger();
		FightTrigger();
		frame.requestFocus();

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
			config.setLevel(config.getLevel() + 1);
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
			new BattleHandler(frame, user, fightSlime.subList(0, Math.min(3, fightSlime.size()))).start();
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

	private void setButtonDisable() {
		dropButton.setEnabled(false);
		equipButton.setEnabled(false);
		useButton.setEnabled(false);
	}
	
	public void slimeMove() {
		ArrayList<Slime> slimeList = gameMap.getSlimeList();
		for(Slime s:slimeList) {
			s.move(userX, userY);
		}
	}
	
	public class DropButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(equipSelect >= 0) {
				double HPPercent = user.getCurrent_HP()/user.getHPDecroted();
				double MPPercent = user.getCurrent_MP()/user.getMPDecroted();
				if (user.getPackageList().size() >= 9) {
					user.getEquipList().remove(getEquip(equipSelect));
				}
				else {
					user.getPackageList().add(getEquip(equipSelect));
					user.getEquipList().remove(getEquip(equipSelect));
				}
				user.setCurrent_HP(Math.ceil(HPPercent*user.getHPDecroted()));
				user.setCurrent_MP(Math.ceil(MPPercent*user.getMPDecroted()));
			}
			else {
				if(user.getPackageList().size()>packageSelect) {
					user.getPackageList().remove(packageSelect);
				}
			}
			refresh();
		}
		
	}
	
	public class EquipButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			equip eq = user.getPackageList().get(packageSelect);
			double HPPercent = user.getCurrent_HP()/user.getHPDecroted();
			double MPPercent = user.getCurrent_MP()/user.getMPDecroted();
			if(eq instanceof Weapon) {
				if(getEquip(0) != null) {
					user.getPackageList().remove(packageSelect);
					user.getPackageList().add(getEquip(0));
					user.getEquipList().remove(getEquip(0));
					user.getEquipList().add(eq);
				}
				else {
					user.getEquipList().add(eq);
					user.getPackageList().remove(packageSelect);
				}
			}
			else if(eq instanceof Armor) {
				if(getEquip(1) != null) {
					user.getPackageList().remove(packageSelect);
					user.getPackageList().add(getEquip(1));
					user.getEquipList().remove(getEquip(1));
					user.getEquipList().add(eq);
				}
				else {
					user.getEquipList().add(eq);
					user.getPackageList().remove(packageSelect);
				}
			}
			else if(eq instanceof Ornament) {
				if(getEquip(2) != null) {
					user.getPackageList().remove(packageSelect);
					user.getPackageList().add(getEquip(2));
					user.getEquipList().remove(getEquip(2));
					user.getEquipList().add(eq);
				}
				else {
					user.getEquipList().add(eq);
					user.getPackageList().remove(packageSelect);
				}
			}
			user.setCurrent_HP(Math.ceil(HPPercent*user.getHPDecroted()));
			user.setCurrent_MP(Math.ceil(MPPercent*user.getMPDecroted()));
			refresh();
		}
		
	}
	
	public class UseButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Medicine med = (Medicine)user.getPackageList().get(packageSelect);
			med.useMedicine(user);
			if (med.getNum() <= 0) {
				user.getPackageList().remove(packageSelect);
			}
			refresh();
		}
		
	}
	
	public class PackageButtonListener implements ActionListener{
		private int packageId;
		
		public PackageButtonListener(int id) {
			this.packageId = id;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			packageSelect = this.packageId;
			equipSelect = -1;
			setButtonDisable();
			if(user.getPackageList().size() > packageId) {
				if(user.getPackageList().get(packageId) instanceof Medicine) {
					dropButton.setEnabled(true);
					useButton.setEnabled(true);
				}
				else {
					dropButton.setEnabled(true);
					equipButton.setEnabled(true);
				}
			}
			frame.requestFocus();
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

			}

			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println(KeyEvent.getKeyText(e.getKeyCode()));
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
