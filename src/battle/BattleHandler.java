package battle;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import slime.GreenSlime;
import slime.RedSlime;
import slime.Slime;
import user.User;

public class BattleHandler{
	private final static int GUIWidth = 1200;
	private final static int GUIHeight = 800;
	private String slime_init_path = "resource/img/b_slime_init.jpg";
	private String slime_attack_path = "resource/img/b_slime_attacked.jpg";
	private String slime_attacked_path = "resource/img/b_slime_attack.jpg";
	private String slime_death_path = "resource/img/b_slime_death.jpg";
	private String user_path = "resource/img/b_user.jpg";
	private String attack_path = "resource/img/b_attack.jpg";
	private String skill1_path = "resource/img/b_skill1.png";
	private String skill2_path = "resource/img/b_skill2.png";
	private String skill3_path = "resource/img/b_skill3.png";
	private String skill4_path = "resource/img/b_skill4.png";
	
	private JFrame battleFrame = null;
	private JPanel battlePanel = null;
	private JPanel statePanel = null;
	private JPanel characterPanel = null;
	private JPanel controlPanel = null;
	private JLabel nameLabel = null;
	private JLabel stateLabel = null;
	private JLabel HPLabel = null;
	private JLabel MPLabel = null;
	private JLabel enameLabel = null;
	private JLabel estateLabel = null;
	private JLabel eHPLabel = null;
	private JLabel eMPLabel = null;
	private JButton eButton1 = null;
	private JButton eButton2 = null;
	private JButton eButton3 = null;
	private JButton atkButton = null;
	private JButton skillButton1 = null;
	private JButton skillButton2 = null;
	private JButton skillButton3 = null;
	private JButton skillButton4 = null;
	private JLabel descLabel = null;
	
	private User user = null;
	private List<Slime> slimeList = null;
	private int slimeNum = 0;
	private Slime slime = null;
	private JButton slimeButton = null;
	private int controlNum = -1;
	private boolean controlACK = false;
	private boolean gameover = false;
	private boolean buttonEnable = true;

	private BattleLogic bl = BattleLogic.getInstance();
	
	public BattleHandler(User user, List<Slime> slimeList) {
		this.user = user;
		this.slimeList = slimeList;
		this.slimeNum = slimeList.size();
		this.slime = slimeList.get(0);
	}
	
	public void start() {
		mapInit();
	}
	
	private void mapInit() {
		new AutoInfo("战 斗 开 始") ;
		bl.waitPro(1500);
		battleFrame = new JFrame("Battle");
		battleFrame.setSize(GUIWidth, GUIHeight);
		battleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		battleFrame.setLocationRelativeTo(null);
		battleFrame.setUndecorated(true);
		
		battlePanel = new JPanel();
		battlePanel.setLayout(null);
		
		wholeSet();
		
		battleFrame.add(battlePanel);
		battleFrame.setVisible(true);
	}
	
	private void wholeSet() {
		JPanel panel = battlePanel;
		statePanel = new JPanel();
		statePanel.setLocation(0,0);
		statePanel.setSize(1200,120);
		statePanel.setLayout(null);
		stateSet();
		
		characterPanel = new JPanel();
		characterPanel.setLocation(0,120);
		characterPanel.setSize(1200,500);
		characterPanel.setLayout(null);
		characterPanel.setBackground(new Color(255,255,255));
		characterSet();
		
		controlPanel = new JPanel();
		controlPanel.setLocation(0,620);
		controlPanel.setSize(1200,180);
		controlPanel.setLayout(null);
		controlSet();
		
		panel.add(statePanel);
		panel.add(characterPanel);
		panel.add(controlPanel);
		
		
	}
	
	private void stateSet() {
		JPanel panel = statePanel;
		//self state
		nameLabel = new JLabel();
		nameLabel.setText(user.getUserName());
		nameLabel.setFont(new Font("Serif", Font.BOLD, 30));
		nameLabel.setForeground(Color.black);
		nameLabel.setLocation(30,10);
		nameLabel.setSize(200,30);
		panel.add(nameLabel);
		
		stateLabel = new JLabel();
		stateLabel.setText("正 常");
		stateLabel.setFont(new Font("Serif", Font.PLAIN, 20));
		stateLabel.setForeground(Color.gray);
		stateLabel.setLocation(330,10);
		stateLabel.setSize(80,40);
		panel.add(stateLabel);
		
		HPLabel = new JLabel();
		HPLabel.setText("生命 : " + (int)user.getCurrent_HP());
		HPLabel.setFont(new Font("Serif", Font.PLAIN, 30));
		HPLabel.setForeground(Color.red);
		HPLabel.setLocation(40,60);
		HPLabel.setSize(240,50);
		panel.add(HPLabel);
		
		MPLabel = new JLabel();
		MPLabel.setText("魔法 : " + (int)user.getCurrent_MP());
		MPLabel.setFont(new Font("Serif", Font.PLAIN, 30));
		MPLabel.setForeground(Color.blue);
		MPLabel.setLocation(320,60);
		MPLabel.setSize(240,50);
		panel.add(MPLabel);

		//enemy state
		enameLabel = new JLabel();
		enameLabel.setText(slime.getSlimeName());
		enameLabel.setFont(new Font("Serif", Font.BOLD, 30));
		enameLabel.setForeground(Color.black);
		enameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		enameLabel.setLocation(970,10);
		enameLabel.setSize(200,30);
		panel.add(enameLabel);
		
		estateLabel = new JLabel();
		estateLabel.setText("正 常");
		estateLabel.setFont(new Font("Serif", Font.PLAIN, 20));
		estateLabel.setForeground(Color.gray);
		estateLabel.setLocation(730,10);
		estateLabel.setSize(80,40);
		panel.add(estateLabel);
		
		eHPLabel = new JLabel();
		eHPLabel.setText("生命 : " + (int)slime.getCurrent_HP());
		eHPLabel.setFont(new Font("Serif", Font.PLAIN, 30));
		eHPLabel.setForeground(Color.red);
		eHPLabel.setLocation(690,60);
		eHPLabel.setSize(240,50);
		panel.add(eHPLabel);
		
		eMPLabel = new JLabel();
		eMPLabel.setText("魔法 : " + (int)slime.getCurrent_MP());
		eMPLabel.setFont(new Font("Serif", Font.PLAIN, 30));
		eMPLabel.setForeground(Color.blue);
		eMPLabel.setLocation(970,60);
		eMPLabel.setSize(240,50);
		panel.add(eMPLabel);
	}
	
	private void characterSet() {
		JPanel panel = characterPanel;
		JLabel userLabel = new JLabel();
		ImageIcon ii = new ImageIcon(user_path);
		ii.setImage(ii.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
		userLabel.setIcon(ii);
		userLabel.setLocation(160,180);
		userLabel.setSize(150,150);
		panel.add(userLabel);
		
		//enemy 1
		eButton1 = new JButton();
		eButton1.setOpaque(true);
		eButton1.setBorder(null);
		eButton1.setBackground(Color.WHITE);
		eButton1.setIcon(getSlimeIcon(1));
		eButton1.setLocation(760,40);
		eButton1.setSize(100,100);
		eButton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(buttonEnable == true && slimeList.get(0).isAlive()) {
					slime = slimeList.get(0);
					slimeButton = eButton1;
					if (controlACK == false) {
						updateStatePanel();
					}else {
						turnBegin();
					}
				}
			}
		});
		panel.add(eButton1);
		
		//enemy 2
		eButton2 = new JButton();
		eButton2.setOpaque(true);
		eButton2.setBorder(null);
		eButton2.setBackground(Color.WHITE);
		eButton2.setIcon(getSlimeIcon(1));
		eButton2.setLocation(760,200);
		eButton2.setSize(100,100);
		eButton2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(buttonEnable == true && slimeList.get(1).isAlive()) {
					slime = slimeList.get(1);
					slimeButton = eButton2;
					if (controlACK == false) {
						updateStatePanel();
					}else {
						turnBegin();
					}
				}
			}
		});
		panel.add(eButton2);
		
		//enemy 3
		eButton3 = new JButton();
		eButton3.setOpaque(true);
		eButton3.setBorder(null);
		eButton3.setBackground(Color.WHITE);
		eButton3.setIcon(getSlimeIcon(1));
		eButton3.setLocation(760,360);
		eButton3.setSize(100,100);
		eButton3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(buttonEnable == true && slimeList.get(2).isAlive()) {
					slime = slimeList.get(2);
					slimeButton = eButton3;
					if (controlACK == false) {
						updateStatePanel();
					}else {
						turnBegin();
					}
				}
			}
		});
		panel.add(eButton3);
		
		if(slimeNum == 1) {
			eButton2.setVisible(false);	
			eButton3.setVisible(false);	
			eButton1.setLocation(760,200);
		}else if(slimeNum == 2) {
			eButton3.setVisible(false);
			eButton1.setLocation(760,100);
			eButton2.setLocation(760,300);
		}
		
	}
	
	private void controlSet() {
		JPanel panel = controlPanel;
		atkButton = new JButton();
		ImageIcon ii0 = new ImageIcon(attack_path);
		ii0.setImage(ii0.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		atkButton.setIcon(ii0);
		atkButton.setLocation(50,40);
		atkButton.setSize(100,100);
		atkButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(buttonEnable == true) {
					if(controlNum == 0 && controlACK == true) {
						controlACK = false;
					}else {
						controlACK = true;
					}
					controlNum = 0;
					updateControlPanel();
				}
			}
		});
		panel.add(atkButton);
		
		skillButton1 = new JButton();
		ImageIcon ii1 = new ImageIcon(skill1_path);
		ii1.setImage(ii1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
		skillButton1.setIcon(ii1);
		skillButton1.setLocation(300,20);
		skillButton1.setSize(70,70);
		skillButton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(buttonEnable == true) {
					if(controlNum == 1 && controlACK == true) {
						controlACK = false;
					}else {
						controlACK = true;
					}
					controlNum = 1;
					updateControlPanel();
				}
			}
		});
		panel.add(skillButton1);
		
		skillButton2 = new JButton();
		ImageIcon ii2 = new ImageIcon(skill2_path);
		ii2.setImage(ii2.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
		skillButton2.setIcon(ii2);
		skillButton2.setLocation(500,20);
		skillButton2.setSize(70,70);
		skillButton2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(buttonEnable == true) {
					if(controlNum == 2 && controlACK == true) {
						controlACK = false;
					}else {
						controlACK = true;
					}
					controlNum = 2;
					updateControlPanel();
				}
			}
		});
		panel.add(skillButton2);
		
		
		skillButton3 = new JButton();
		ImageIcon ii3 = new ImageIcon(skill3_path);
		ii3.setImage(ii3.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
		skillButton3.setIcon(ii3);
		skillButton3.setLocation(700,20);
		skillButton3.setSize(70,70);
		skillButton3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(buttonEnable == true) {
					if(controlNum == 3 && controlACK == true) {
						controlACK = false;
					}else {
						controlACK = true;
					}
					controlNum = 3;
					updateControlPanel();
				}
			}
		});
		panel.add(skillButton3);
		
		skillButton4 = new JButton();
		ImageIcon ii4 = new ImageIcon(skill4_path);
		ii4.setImage(ii4.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
		skillButton4.setIcon(ii4);
		skillButton4.setLocation(900,20);
		skillButton4.setSize(70,70);
		skillButton4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(buttonEnable == true) {
					if(controlNum == 4 && controlACK == true) {
						controlACK = false;
					}else {
						controlACK = true;
					}
					controlNum = 4;
					updateControlPanel();
				}
			}
		});
		panel.add(skillButton4);
		
		descLabel = new JLabel();
		if (controlNum == 0) {
			descLabel.setText("普通攻击");
		}else if (controlNum == 1) {
			descLabel.setText("技能1描述");
		}else if (controlNum == 2) {
			descLabel.setText("技能2描述");
		}else if (controlNum == 3) {
			descLabel.setText("技能3描述");
		}else if (controlNum == 4) {
			descLabel.setText("技能4描述");
		}
		descLabel.setFont(new Font("Serif", Font.PLAIN, 20));
		descLabel.setOpaque(true);
		descLabel.setBackground(Color.green);
		descLabel.setLocation(280,120);
		descLabel.setSize(800,30);
		panel.add(descLabel);
	}
	
	private JButton getSlimeButton(int i) {
		if(i==1) {
			return eButton1;
		}else if(i==2) {
			return eButton2;
		}else if(i==3) {
			return eButton3;
		}
		return null;
	}
	
	private void userATKHandler() {
		slimeButton.setIcon(getSlimeIcon(2));
		bl.waitPro(1000);
		bl.userATK(user, slime, controlNum);
		if (!slime.isAlive()) {
			slimeButton.setIcon(getSlimeIcon(4));
		}else {
			slimeButton.setIcon(getSlimeIcon(1));
		}
		if(bl.isSuccess(slimeList)) {
			bl.waitPro(1000);
			gameoverWithSuccess();
		}
		
	}
	
	private void enemyATKHandler() {
		for (int i=0;i<slimeNum;i++) {
			slime = slimeList.get(i);
			if(slime.isAlive()) {
				getSlimeButton(i+1).setIcon(getSlimeIcon(3));
				updateStatePanel();
				bl.waitPro(1000);
				bl.enemyATK(slime, user);
				updateStatePanel();
				updateUserState();
				bl.waitPro(1000);
				if (bl.isFailure(user)) {
					gameoverWithFailure();
					break;
				}
				getSlimeButton(i+1).setIcon(getSlimeIcon(1));
			}
		}
	}
	
	private void updateStatePanel() {
		HPLabel.setText("生命 : " + (int)user.getCurrent_HP());
		MPLabel.setText("魔法 : " + (int)user.getCurrent_MP());
		
		eHPLabel.setText("生命 : " + (int)slime.getCurrent_HP());
		eMPLabel.setText("魔法 : " + (int)slime.getCurrent_MP());
		

		battlePanel.updateUI();
	}
	
	private void updateUserState() {
		if (user.getState().getLastTime()>=1) {
			stateLabel.setText("中 毒");
		}else {
			stateLabel.setText("正 常");
		}
		battlePanel.updateUI();
	}
	
	private void updateControlPanel() {
		if (controlNum == 0) {
			descLabel.setText("普通攻击");
		}else if (controlNum == 1) {
			descLabel.setText("技能1");
		}else if (controlNum == 2) {
			descLabel.setText("技能2");
		}else if (controlNum == 3) {
			descLabel.setText("技能3");
		}else if (controlNum == 4) {
			descLabel.setText("技能4");
		}

		battlePanel.updateUI();
	}		
	
	private ImageIcon getSlimeIcon(int i) {
		ImageIcon ii = null;
		if (i==1) {
			ii = new ImageIcon(slime_init_path);
			ii.setImage(ii.getImage().getScaledInstance(120, 100, Image.SCALE_DEFAULT));
		}else if(i==2) {
			ii = new ImageIcon(slime_attacked_path);
			ii.setImage(ii.getImage().getScaledInstance(120, 100, Image.SCALE_DEFAULT));
		}else if(i==3) {
			ii = new ImageIcon(slime_attack_path);
			ii.setImage(ii.getImage().getScaledInstance(120, 100, Image.SCALE_DEFAULT));
		}else if(i==4){
			ii = new ImageIcon(slime_death_path);
			ii.setImage(ii.getImage().getScaledInstance(120, 100, Image.SCALE_DEFAULT));
		}
		return ii;
	}
	
	private void gameoverWithFailure() {
		new AutoInfo("战 斗 失 败") ;
		gameover = true;
		battleFrame.dispose();
	}
	
	private void gameoverWithSuccess() {
		new AutoInfo("战 斗 胜 利") ;
		gameover = true;
		battleFrame.dispose();
	}
	
	private void userInpoisonHandler() {
		if (bl.isUserInPoison(user)) {
			bl.userInPoisonInvoker(user);
			updateUserState();
			updateStatePanel();
			if(bl.isFailure(user)) {
				bl.waitPro(1000);
				gameoverWithFailure();
			}
		}
	}
	
	private void turnBegin() {
		buttonEnable = false;
		new Thread() {
			@Override
			public void run() {
				userATKHandler();
				updateStatePanel();
				bl.waitPro(1000);
				
				if(gameover==false) {
					new AutoInfo("敌 方 回 合") ;
					bl.waitPro(1500);
					
					enemyATKHandler();
					
					if(gameover==false) {
						new AutoInfo("我 方 回 合") ;
						bl.waitPro(1500);
						userInpoisonHandler();
						buttonEnable = true;
					}
				}
				controlACK = false;
				controlNum = -1;
			}
		}.start();
	}

	
	public static void main(String[] args) {
		User user =new User("大魔王",2);
		user.setCurrent_HP(30);
		user.setP_ATK(20);
		List<Slime> slimeList = new ArrayList<Slime>();
		Slime slime1 = new GreenSlime();
		slime1.setCurrent_HP(30);
		slime1.setP_ATK(10);
		slimeList.add(slime1);
		Slime slime2 = new RedSlime();
		slime2.setCurrent_HP(30);
		slime2.setP_ATK(10);
		slimeList.add(slime2);
//		Slime slime3 = new GreenSlime();
//		slime3.setCurrent_HP(52);
//		slime3.setP_ATK(10);
//		slimeList.add(slime3);
		new BattleHandler(user, slimeList).start();
	}
	
}
