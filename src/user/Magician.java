package user;

public class Magician extends User{
	private static final String path = System.getProperty("user.dir") + "/resource/img/magician.jpg";
	private static final int type = 0;
	
	public Magician(String userName) {
		super(userName, type);
		this.imagePath = path;
	}
}
