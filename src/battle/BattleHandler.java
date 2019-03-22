package battle;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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
//		new AutoInfo("战 斗 开 始") ;
//		bl.waitPro(1500);
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
		nameLabel.setLocation(30,10);
		nameLabel.setSize(200,30);
		panel.add(nameLabel);
		
		stateLabel = new JLabel();
		stateLabel.setText("状态");
		stateLabel.setFont(new Font("Serif", Font.PLAIN, 20));
		stateLabel.setLocation(330,10);
		stateLabel.setSize(80,40);
		panel.add(stateLabel);
		
		HPLabel = new JLabel();
		HPLabel.setText("生命 : " + (int)user.getCurrent_HP());
		HPLabel.setFont(new Font("Serif", Font.PLAIN, 40));
		HPLabel.setLocation(40,60);
		HPLabel.setSize(240,50);
		panel.add(HPLabel);
		
		MPLabel = new JLabel();
		MPLabel.setText("魔法 : " + (int)user.getCurrent_MP());
		MPLabel.setFont(new Font("Serif", Font.PLAIN, 40));
		MPLabel.setLocation(320,60);
		MPLabel.setSize(240,50);
		panel.add(MPLabel);

		//enemy state
		enameLabel = new JLabel();
		enameLabel.setText(slime.getSlimeName());
		enameLabel.setFont(new Font("Serif", Font.BOLD, 30));
		enameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		enameLabel.setLocation(970,10);
		enameLabel.setSize(200,30);
		panel.add(enameLabel);
		
		estateLabel = new JLabel();
		estateLabel.setText("状态");
		estateLabel.setFont(new Font("Serif", Font.PLAIN, 20));
		estateLabel.setLocation(730,10);
		estateLabel.setSize(80,40);
		panel.add(estateLabel);
		
		eHPLabel = new JLabel();
		eHPLabel.setText("生命 : " + (int)slime.getCurrent_HP());
		eHPLabel.setFont(new Font("Serif", Font.PLAIN, 40));
		eHPLabel.setLocation(640,60);
		eHPLabel.setSize(240,50);
		panel.add(eHPLabel);
		
		eMPLabel = new JLabel();
		eMPLabel.setText("魔法 : " + (int)slime.getCurrent_MP());
		eMPLabel.setFont(new Font("Serif", Font.PLAIN, 40));
		eMPLabel.setLocation(920,60);
		eMPLabel.setSize(240,50);
		panel.add(eMPLabel);
	}
	
	private void characterSet() {
		JPanel panel = characterPanel;
		JLabel userLabel = new JLabel();
		userLabel.setOpaque(true);
		userLabel.setBackground(Color.GREEN);
		userLabel.setLocation(160,180);
		userLabel.setSize(150,150);
		panel.add(userLabel);
		
		//enemy 1
		eButton1 = new JButton();
		eButton1.setOpaque(true);
		eButton1.setBackground(Color.GREEN);
		eButton1.setLocation(760,40);
		eButton1.setSize(100,100);
		eButton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				slime = slimeList.get(0);
				slimeButton = eButton1;
				if (controlACK == false) {
					updateStatePanel();
				}else {
					controlButtonDisable();
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
									controlButtonEnable();
								}
							}
							controlACK = false;
							controlNum = -1;
						}
					}.start();
				}
			}
		});
		panel.add(eButton1);
		
		//enemy 2
		eButton2 = new JButton();
		eButton2.setOpaque(true);
		eButton2.setBackground(Color.GREEN);
		eButton2.setLocation(760,200);
		eButton2.setSize(100,100);
		eButton2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				slime = slimeList.get(1);
				slimeButton = eButton2;
				if (controlACK == false) {
					updateStatePanel();
				}else {
					controlButtonDisable();
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
									controlButtonEnable();
								}
							}
							controlACK = false;
							controlNum = -1;
						}
					}.start();
				}
			}
		});
		panel.add(eButton2);
		
		//enemy 3
		eButton3 = new JButton();
		eButton3.setOpaque(true);
		eButton3.setBackground(Color.GREEN);
		eButton3.setLocation(760,360);
		eButton3.setSize(100,100);
		eButton3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				slime = slimeList.get(2);
				slimeButton = eButton3;
				if (controlACK == false) {
					updateStatePanel();
				}else {
					controlButtonDisable();
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
									controlButtonEnable();
								}
							}
							controlACK = false;
							controlNum = -1;
						}
					}.start();
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
		atkButton.setOpaque(true);
		atkButton.setBackground(Color.GREEN);
		atkButton.setLocation(50,40);
		atkButton.setSize(100,100);
		atkButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(controlNum == 0) {
					controlACK = false;
				}else {
					controlACK = true;
				}
				controlNum = 0;
				updateControlPanel();
			}
		});
		panel.add(atkButton);
		
		skillButton1 = new JButton();
		skillButton1.setOpaque(true);
		skillButton1.setBackground(Color.GREEN);
		skillButton1.setLocation(300,20);
		skillButton1.setSize(70,70);
		skillButton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(controlNum == 1) {
					controlACK = false;
				}else {
					controlACK = true;
				}
				controlNum = 1;
				updateControlPanel();
			}
		});
		panel.add(skillButton1);
		
		skillButton2 = new JButton();
		skillButton2.setOpaque(true);
		skillButton2.setBackground(Color.GREEN);
		skillButton2.setLocation(500,20);
		skillButton2.setSize(70,70);
		skillButton2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(controlNum == 2) {
					controlACK = false;
				}else {
					controlACK = true;
				}
				controlNum = 2;
				updateControlPanel();
			}
		});
		panel.add(skillButton2);
		
		
		skillButton3 = new JButton();
		skillButton3.setOpaque(true);
		skillButton3.setBackground(Color.GREEN);
		skillButton3.setLocation(700,20);
		skillButton3.setSize(70,70);
		skillButton3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(controlNum == 3) {
					controlACK = false;
				}else {
					controlACK = true;
				}
				controlNum = 3;
				updateControlPanel();
			}
		});
		panel.add(skillButton3);
		
		skillButton4 = new JButton();
		skillButton4.setOpaque(true);
		skillButton4.setBackground(Color.GREEN);
		skillButton4.setLocation(900,20);
		skillButton4.setSize(70,70);
		skillButton4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(controlNum == 4) {
					controlACK = false;
				}else {
					controlACK = true;
				}
				controlNum = 4;
				updateControlPanel();
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
	
	private void controlButtonDisable() {
		eButton1.setEnabled(false);
		eButton2.setEnabled(false);
		eButton3.setEnabled(false);
		atkButton.setEnabled(false);
		skillButton1.setEnabled(false);
		skillButton2.setEnabled(false);
		skillButton3.setEnabled(false);
		skillButton4.setEnabled(false);
		battlePanel.updateUI();
	}
	
	private void controlButtonEnable() {
		for (int i=0;i<slimeNum;i++) {
			if (slimeList.get(i).isAlive()) {
				getSlimeButton(i+1).setEnabled(true);
			}
		}
		atkButton.setEnabled(true);
		skillButton1.setEnabled(true);
		skillButton2.setEnabled(true);
		skillButton3.setEnabled(true);
		skillButton4.setEnabled(true);
		battlePanel.updateUI();
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
		slimeButton.setBackground(Color.gray);
		bl.waitPro(1000);
		bl.userATK(user, slime, controlNum);
		if (!slime.isAlive()) {
			slimeButton.setBackground(Color.black);
		}else {
			slimeButton.setBackground(Color.green);
		}
		if(bl.isSuccess(slimeList)) {
			bl.waitPro(1000);
			new AutoInfo("战 斗 胜 利") ;
			gameover = true;
			battleFrame.dispose();
		}
		
	}
	
	private void enemyATKHandler() {
		for (int i=0;i<slimeNum;i++) {
			slime = slimeList.get(i);
			if(slime.isAlive()) {
				getSlimeButton(i+1).setBackground(Color.red);
				updateStatePanel();
				bl.waitPro(1000);
				bl.enemyATK(slime, user);
				updateStatePanel();
				bl.waitPro(1000);
				if (bl.isFailure(user)) {
					new AutoInfo("战 斗 失 败") ;
					gameover = true;
					battleFrame.dispose();
					break;
				}
				getSlimeButton(i+1).setBackground(Color.green);
			}
		}
	}
	
	private void updateStatePanel() {
		nameLabel.setText(user.getUserName());
		stateLabel.setText("状态");
		HPLabel.setText("生命 : " + (int)user.getCurrent_HP());
		MPLabel.setText("魔法 : " + (int)user.getCurrent_MP());
		
		enameLabel.setText(slime.getSlimeName());
		estateLabel.setText("状态");
		eHPLabel.setText("生命 : " + (int)slime.getCurrent_HP());
		eMPLabel.setText("魔法 : " + (int)slime.getCurrent_MP());
		

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

	
	public static void main(String[] args) {
		User user =new User("大魔王",2);
		user.setCurrent_HP(100);
		user.setP_ATK(20);
		List<Slime> slimeList = new ArrayList<Slime>();
		Slime slime1 = new GreenSlime();
		slime1.setCurrent_HP(50);
		slime1.setP_ATK(10);
		slimeList.add(slime1);
//		Slime slime2 = new RedSlime();
//		slime2.setCurrent_HP(51);
//		slime2.setP_ATK(10);
//		slimeList.add(slime2);
//		Slime slime3 = new GreenSlime();
//		slime3.setCurrent_HP(52);
//		slime3.setP_ATK(10);
//		slimeList.add(slime3);
		new BattleHandler(user, slimeList).start();
	}
	
}
