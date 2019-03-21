package user;

public class Assassin extends User{
	private static final String path = System.getProperty("user.dir") + "/resource/img/paidaxing.jpg";
	private static final int type = 0;
	
	public Assassin(String userName) {
		super(userName, type);
		this.imagePath = path;
	}
}
