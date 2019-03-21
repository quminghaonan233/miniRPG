package user;

public class Warrior extends User{
	private static final String path = System.getProperty("user.dir") + "/resource/img/paidaxing.jpg";
	private static final int type = 2;
	
	public Warrior(String userName) {
		super(userName, type);
		this.imagePath = path;
	}
	
}
