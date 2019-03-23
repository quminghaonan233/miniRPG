package user;

public class Assassin extends User{
	private static final String path = System.getProperty("user.dir") + "/resource/img/paidaxing.jpg";
	private static final int type = 0;
	
	public Assassin(String userName) {
		super(userName, type);
		this.imagePath = path;
		this.growHP = 15;
		this.growMP = 10;
		this.growP_ATK = 5;
		this.growP_DEF = 2;
		this.growM_ATK = 2;
		this.growM_DEF = 3;
		this.LV = 1;
		
		this.current_HP = 100;
		this.HP = 100;
		this.MP = 50;
		this.current_MP = 50;

	}
}
