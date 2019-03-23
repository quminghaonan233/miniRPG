package Medicine;

import user.User;
import weapon.equip;

public class Medicine extends equip{
	public void useMedicine(User u) {
		u.setCurrent_HP(Math.min(u.getCurrent_HP() + 10,u.getHPDecroted()));
		this.num = this.num - 1;
	}
}
