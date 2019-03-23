package weapon;

public class FrostMourn extends Weapon{
	public FrostMourn() {
		super();		
		this.setP_ATK(50);
		this.setAGI(10);
		this.setSTR(10);
		this.setProbability(2);
		this.setImagePath(System.getProperty("user.dir") + "/resource/img/FrostMourn.png");
	}
}
