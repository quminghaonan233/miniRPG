package Medicine;

import user.User;

public class MagicMedicine extends Medicine{
	public MagicMedicine() {
		this.probability = 100;
		this.setImagePath(System.getProperty("user.dir") + "/resource/img/MagicMedicine.png");
	}
	
	public void useMedicine(User u) {
		u.setCurrent_MP(Math.min(u.getCurrent_MP() + 100,u.getMPDecroted()));
		this.num = this.num - 1;
	}
}
