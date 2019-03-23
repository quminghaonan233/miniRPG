package slime;


public class RedSlime extends Slime{
	private static final String path = System.getProperty("user.dir") + "/resource/img/redSlime.png";
	private static final int type = 1;
	
	
	public RedSlime(int x,int y, int level) {
		super();
		this.imagePath = path;
		this.SlimeType = type;
		this.posX = x;
		this.posY = y;
		this.LV = level;
		
		this.HP = 1000;
		this.MP = 200;
		this.EXP = 35+(level-1)*5;
		this.P_ATK = 70;
		this.P_DEF = 30;
		this.M_ATK = 50;
		this.M_DEF = 30;
		this.growHP = 80;
		this.growMP = 0;
		this.growP_ATK = 3;
		this.growP_DEF = 2;
		this.growM_ATK = 2;
		this.growM_DEF = 2;

		this.current_HP = this.getHPDecroted();
		this.current_MP = this.getMPDecroted();
	}
	
	public String getSlimeName() {
		return "ºìÉ«Ê·À³Ä·";
	}
}
