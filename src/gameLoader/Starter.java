package gameLoader;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Starter{
	//界面大小
	private final static int GUIWidth = 1200;
	private final static int GUIHeight = 800;
	//按钮大小
	private final static int ButtonWidth = 180;
	private final static int ButtonHeight = 40;
	
	private final static int newGameButtony = 480;
	private final static int continueGameButtony = 540;
	private final static int exitGameButtony = 600 ;
	
	private final static Font ButtonFont = new Font("仿宋", Font.PLAIN, 25);
	
	private JFrame frame = null;

	
    /**{
     * 创建并显示GUI。出于线程安全的考虑，
     * 这个方法在事件调用线程中调用。
     */
    private void GUIInitialzation() {
    	frame = new JFrame("MiniRPG_start");

        frame.setSize(GUIWidth, GUIHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();    

        frame.add(panel);

        placeComponents(panel);

        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {

    	GameLoaderUtil glu = GameLoaderUtil.getInstance();
        panel.setLayout(null);

        JButton newGameBtn = new JButton("新的征程");
        newGameBtn.setBounds((GUIWidth-ButtonWidth)/2,newGameButtony,ButtonWidth,ButtonHeight);
        newGameBtn.addActionListener(new NewGameButtonListener(frame));
        panel.add(newGameBtn);

        JButton continueGameBtn = new JButton("再续前路");
        continueGameBtn.setBounds((GUIWidth-ButtonWidth)/2,continueGameButtony,ButtonWidth,ButtonHeight);
        continueGameBtn.addActionListener(new ContinueGameButtonListener(frame));
        //首次游戏无存档不可点击
        if(glu.judgeFirstGame()) {
        	continueGameBtn.setEnabled(false);
        }
        panel.add(continueGameBtn);
        
        JButton exitGameBtn = new JButton("退出游戏");
        exitGameBtn.setBounds((GUIWidth-ButtonWidth)/2,exitGameButtony,ButtonWidth,ButtonHeight);
        exitGameBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
			}
		});
        panel.add(exitGameBtn);
        
        newGameBtn.setFont(ButtonFont);
        continueGameBtn.setFont(ButtonFont);
        exitGameBtn.setFont(ButtonFont);

    }

    public static void main(String[] args) {
        // 显示应用 GUI
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	new Starter().GUIInitialzation();
            }
        });
    }
}