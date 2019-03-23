package weapon;

public class DarkScarf extends Armor{
	public DarkScarf() {
		super();
		this.setM_DEF(30);
		this.setM_ATK(10);
		this.probability = 20;
		this.setImagePath(System.getProperty("user.dir") + "/resource/img/DarkScarf.png");
	}
}
