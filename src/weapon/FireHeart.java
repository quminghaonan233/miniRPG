package weapon;

public class FireHeart extends Ornament{
	public FireHeart() {
		super();
		this.setSTR(30);
		this.probability = 10;
		this.setImagePath(System.getProperty("user.dir") + "/resource/img/FireHeart.png");
	}
}
