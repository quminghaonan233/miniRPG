package weapon;

public class Knife extends Weapon{
	public Knife() {
		super();
		this.setP_ATK(40);
		this.setAGI(10);
		this.setImagePath(System.getProperty("user.dir") + "/resource/img/Knife.png");
	}
}
