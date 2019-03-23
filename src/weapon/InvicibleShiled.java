package weapon;

public class InvicibleShiled extends Weapon{
	public InvicibleShiled() {
		super();
		this.setM_DEF(40);
		this.setM_ATK(20);
		this.probability = 2;
		this.setImagePath(System.getProperty("user.dir") + "/resource/img/InvicibleShiled.png");
	}
}
