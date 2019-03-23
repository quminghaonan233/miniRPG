package slime;


public class GreenSlime extends Slime {
	private final static String path = System.getProperty("user.dir") + "/resource/img/greenSlime.jpg";
	private static final int type = 0;

	public GreenSlime() {
		super();
		this.imagePath = path;
		this.SlimeType = type;
	}
	
	public GreenSlime(int x,int y, int level) {
		super();
		this.imagePath = path;
		this.SlimeType = type;
		this.posX = x;
		this.posY = y;
		this.LV = level;
		
		this.HP = 800;
		this.MP = 200;
		this.LV = 1;
		this.P_ATK = 50;
		this.P_DEF = 30;
		this.M_ATK = 70;
		this.M_DEF = 30;
		this.growHP = 80;
		this.growMP = 0;
		this.growP_ATK = 2;
		this.growP_DEF = 2;
		this.growM_ATK = 3;
		this.growM_DEF = 2;		
	}
	
	public String getSlimeName() {
		return "ÂÌÉ«Ê·À³Ä·";
	}
}
