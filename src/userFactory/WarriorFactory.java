package userFactory;

import user.User;
import user.Warrior;

public class WarriorFactory implements UserFactory{
	private static WarriorFactory factory;
	
	private WarriorFactory() {

	}
	
	public static WarriorFactory getInstance() {
		if(factory == null) {
			factory = new WarriorFactory();
		}
		return factory;
	}
	
	@Override
	public User createUser(String userName) {
		// TODO Auto-generated method stub
		return new Warrior(userName);
	}
	
}
