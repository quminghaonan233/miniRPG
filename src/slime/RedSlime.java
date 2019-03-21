package slime;

public class RedSlime extends Slime{
	private static final String path = System.getProperty("user.dir") + "/resource/img/redSlime.png";
	private static final int type = 1;
	
	public RedSlime() {
		super();
		this.imagePath = path;
		this.SlimeType = type;
	}
}
