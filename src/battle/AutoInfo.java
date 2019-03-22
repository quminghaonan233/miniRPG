package battle;

import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class AutoInfo {  
	private JFrame infoFrame;
	private JLabel infoLabel;
	private final static int GUIWidth = 200;
	private final static int GUIHeight = 40;
	
	public AutoInfo(String s) {
		infoFrame = new JFrame("info");
		infoFrame.setSize(GUIWidth, GUIHeight);
		infoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		infoFrame.setLocationRelativeTo(null);
		infoFrame.setUndecorated(true);
		
		infoLabel = new JLabel(s,JLabel.CENTER);
		infoLabel.setFont(new Font("Serif", Font.PLAIN, 40));
		infoLabel.setSize(50,50);
		
		infoFrame.add(infoLabel);
		infoFrame.setVisible(true);
		
		// 创建一个新计时器  
        Timer timer = new Timer();  
  
        // 1.5秒 后执行该任务  
        timer.schedule(new TimerTask() {  
            public void run() {  
            	infoFrame.dispose();  
            	timer.cancel();
            }  
        }, 1500);  
	}
  
}  