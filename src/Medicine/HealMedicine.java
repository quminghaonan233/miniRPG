package Medicine;

import user.User;

public class HealMedicine extends Medicine{
	public HealMedicine() {
		this.probability = 100;
		this.setImagePath(System.getProperty("user.dir") + "/resource/img/HealMedicine.png");
	}
	
	public void useMedicine(User u) {
		u.setCurrent_HP(Math.min(u.getCurrent_HP() + 100,u.getHPDecroted()));
		this.num = this.num - 1;
	}
}
