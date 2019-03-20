package gameLoader;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Starter{
	//�����С
	private final static int GUIWidth = 1200;
	private final static int GUIHeight = 800;
	//��ť��С
	private final static int ButtonWidth = 180;
	private final static int ButtonHeight = 40;
	
	private final static int newGameButtony = 480;
	private final static int continueGameButtony = 540;
	private final static int exitGameButtony = 600 ;
	
	private final static Font ButtonFont = new Font("����", Font.PLAIN, 25);
	
	private JFrame frame = null;

	
    /**{
     * ��������ʾGUI�������̰߳�ȫ�Ŀ��ǣ�
     * ����������¼������߳��е��á�
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

        JButton newGameBtn = new JButton("�µ�����");
        newGameBtn.setBounds((GUIWidth-ButtonWidth)/2,newGameButtony,ButtonWidth,ButtonHeight);
        newGameBtn.addActionListener(new NewGameButtonListener(frame));
        panel.add(newGameBtn);

        JButton continueGameBtn = new JButton("����ǰ·");
        continueGameBtn.setBounds((GUIWidth-ButtonWidth)/2,continueGameButtony,ButtonWidth,ButtonHeight);
        continueGameBtn.addActionListener(new ContinueGameButtonListener(frame));
        //�״���Ϸ�޴浵���ɵ��
        if(glu.judgeFirstGame()) {
        	continueGameBtn.setEnabled(false);
        }
        panel.add(continueGameBtn);
        
        JButton exitGameBtn = new JButton("�˳���Ϸ");
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
        // ��ʾӦ�� GUI
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	new Starter().GUIInitialzation();
            }
        });
    }
}