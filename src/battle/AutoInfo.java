package battle;

import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JDialog;
import javax.swing.JLabel;

public class AutoInfo {  
	private JDialog infoDialog;
	private JLabel infoLabel;
	private final static int GUIWidth = 200;
	private final static int GUIHeight = 40;
	
	public AutoInfo(String s) {
		infoDialog = new JDialog();
		infoDialog.setSize(GUIWidth, GUIHeight);
		infoDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		infoDialog.setLocationRelativeTo(null);
		infoDialog.setUndecorated(true);
		
		infoLabel = new JLabel(s,JLabel.CENTER);
		infoLabel.setFont(new Font("Serif", Font.PLAIN, 40));
		infoLabel.setSize(50,50);
		
		infoDialog.add(infoLabel);
		infoDialog.setVisible(true);
		infoDialog.requestFocus();
		
		// 创建一个新计时器  
        Timer timer = new Timer();  
  
        // 0.7秒 后执行该任务  
        timer.schedule(new TimerTask() {  
            public void run() {  
            	infoDialog.dispose();  
            	timer.cancel();
            }  
        }, 700);  
	}
  
}  