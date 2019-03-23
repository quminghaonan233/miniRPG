package weapon;


public class Killer extends Weapon{
	public Killer() {
		super();
		this.setP_ATK(40);
		this.setSTR(10);
		this.setImagePath(System.getProperty("user.dir") + "/resource/img/Killer.png");
	}
}
