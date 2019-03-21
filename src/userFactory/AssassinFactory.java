package userFactory;

import user.Assassin;
import user.User;

public class AssassinFactory implements UserFactory{
	private static AssassinFactory factory;
	
	private AssassinFactory() {

	}
	
	public static AssassinFactory getInstance() {
		if(factory == null) {
			factory = new AssassinFactory();
		}
		return factory;
	}
	
	@Override
	public User createUser(String userName) {
		// TODO Auto-generated method stub
		return new Assassin(userName);
	}
}
