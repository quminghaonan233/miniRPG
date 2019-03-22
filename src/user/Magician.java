package user;

public class Magician extends User{
	private static final String path = System.getProperty("user.dir") + "/resource/img/magician.jpg";
	private static final int type = 0;
	
	public Magician(String userName) {
		super(userName, type);
		this.imagePath = path;
		this.growHP = 30;
		this.growMP = 10;
		this.growP_ATK = 2;
		this.growP_DEF = 3;
		this.growM_ATK = 6;
		this.growM_DEF = 4;
	}
}
