package gameLoader;

import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import MapLabel.EmptyLabel;
import slime.Slime;
import slime.SlimeType;
import user.User;

public class GameInitializer {
	
	private static ImageIcon emptyImageIcon = new ImageIcon(System.getProperty("user.dir") + "/resource/img/empty.png");
	private static ImageIcon mixImageIcon = new ImageIcon(System.getProperty("user.dir") + "/resource/img/mixSlime.png");
	private static ImageIcon startIcon = new ImageIcon(System.getProperty("user.dir") + "/resource/img/startPoint.jpg");
	private static ImageIcon endIcon = new ImageIcon(System.getProperty("user.dir") + "/resource/img/endPoint.png");

	private final static int GUIWidth = 1200;
	private final static int GUIHeight = 800;
	private final static int startX = 20;
	private final static int startY = 20;
	private final static int endX = 708;
	private final static int endY = 708;
	private final static int imageWidth = (endX-startX)/GameMap.xSize;
	private final static int imageHeight = (endY-startY)/GameMap.ySize;
	
	private User user;
	private GameMap gameMap;
	private int userX;
	private int userY;
	
	private JFrame frame;
	
	private JLabel[][] labelList;
	
	public GameInitializer(User u,GameMap m) {
		this.user = u;
		this.gameMap = m;
		this.userX = m.getStartX();
		this.userY = m.getStartY();
		
	    frame = new JFrame("miniRPG");
	    
	    frame.setSize(GUIWidth, GUIHeight);
	    frame.setLocationRelativeTo(null);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
        JPanel panel = new JPanel();    
        placeComponnets(panel);
        frame.add(panel);
	    
	    
	}
	
	private void placeComponnets(JPanel panel) {
        panel.setLayout(null);

		labelList = new JLabel[GameMap.xSize][GameMap.ySize];
		EmptyLabel l = new EmptyLabel();
		for(int i = 0 ;i<GameMap.xSize;i++) {
			for(int j = 0; j<GameMap.ySize;j++) {
				JLabel temp = l.clone();
				int x1 = startX + i * (endX-startX)/GameMap.xSize;
				int y1 = startY + j * (endY-startY)/GameMap.ySize;
				temp.setBounds(x1,y1,imageWidth,imageHeight);
				temp.setBorder(BorderFactory.createLineBorder(Color.GRAY));
				labelList[i][j] = temp;
				panel.add(temp);
			}
		}
	}
	
	
	public void initializeGame() {
		refresh();
	}
	
	public void refresh() {
		refreshStartEndPoint();
		refreshSlime();
		refreshUser();
		frame.setVisible(true);
		FightTrigger();
	}
	
	private void refreshStartEndPoint() {
		startIcon.setImage(startIcon.getImage().getScaledInstance(imageWidth,imageHeight,Image.SCALE_DEFAULT));
		labelList[gameMap.getStartX()][gameMap.getStartY()].setIcon(startIcon);
		endIcon.setImage(endIcon.getImage().getScaledInstance(imageWidth,imageHeight,Image.SCALE_DEFAULT));
		labelList[gameMap.getEndX()][gameMap.getEndY()].setIcon(endIcon);	
	}
	
	
	private void refreshUser() {
		
	}
	
	private void FightTrigger() {
		
	}
	
	private void refreshSlime() {
		Area[][] areaMap = gameMap.getAreaMap();
		for(int i = 0 ;i<GameMap.xSize;i++) {
			for(int j = 0; j<GameMap.ySize;j++) {
				if(labelList[i][j].getIcon() == null) {
					if(areaMap[i][j] == null || areaMap[i][j].getSlimeList().size() <= 0) {
						emptyImageIcon.setImage(emptyImageIcon.getImage().getScaledInstance(imageWidth,imageHeight,Image.SCALE_DEFAULT));
						labelList[i][j].setIcon(emptyImageIcon);
					}
					else {
						if(!sameSlime(areaMap[i][j].getSlimeList())) {
							mixImageIcon.setImage(mixImageIcon.getImage().getScaledInstance(imageWidth,imageHeight,Image.SCALE_DEFAULT));
							labelList[i][j].setIcon(mixImageIcon);
						}
						else {
							ImageIcon slimeIcon = new ImageIcon(areaMap[i][j].getSlimeList().get(0).getImagePath());
							slimeIcon.setImage(slimeIcon.getImage().getScaledInstance(imageWidth,imageHeight,Image.SCALE_DEFAULT));
							labelList[i][j].setIcon(slimeIcon);
						}
					}
				}
			}
		}
	}
	
	public boolean sameSlime(ArrayList<Slime> slimeList) {
		if(slimeList.size() > 1) {
			int type = slimeList.get(0).getSlimeType();
			for(Slime s:slimeList) {
				if(s.getSlimeType() != type) {
					return false;
				}
			}
		}
		return true;
	}
	
	
}
