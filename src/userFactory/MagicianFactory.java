package userFactory;

import user.Magician;
import user.User;

public class MagicianFactory implements UserFactory{
	private static MagicianFactory factory;
	
	private MagicianFactory() {

	}
	
	public static MagicianFactory getInstance() {
		if(factory == null) {
			factory = new MagicianFactory();
		}
		return factory;
	}
	
	@Override
	public User createUser(String userName) {
		// TODO Auto-generated method stub
		return new Magician(userName);
	}
}
