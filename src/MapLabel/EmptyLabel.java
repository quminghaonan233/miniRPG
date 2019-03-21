package MapLabel;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class EmptyLabel extends JLabel implements Cloneable{
	
	private static Icon icon=null;
	
	public EmptyLabel() {
		super(icon, JLabel.CENTER);
	}

	@Override
	public EmptyLabel clone(){
		try {
			return (EmptyLabel)super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
