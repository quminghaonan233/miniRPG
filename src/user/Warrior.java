package user;

public class Warrior extends User{
	private static final String path = System.getProperty("user.dir") + "/resource/img/paidaxing.jpg";
	private static final int type = 2;
	
	public Warrior(String userName) {
		super(userName, type);
		this.imagePath = path;
		this.growHP = 30;
		this.growMP = 10;
		this.growP_ATK = 5;
		this.growP_DEF = 3;
		this.growM_ATK = 2;
		this.growM_DEF = 2;
	}
}
