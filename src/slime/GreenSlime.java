package slime;


public class GreenSlime extends Slime {
	private final static String path = System.getProperty("user.dir") + "/resource/img/greenSlime.jpg";
	private static final int type = 0;

	public GreenSlime() {
		super();
		this.imagePath = path;
		this.SlimeType = type;
	}
}
