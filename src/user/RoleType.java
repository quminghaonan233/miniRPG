package user;

import userFactory.AssassinFactory;
import userFactory.MagicianFactory;
import userFactory.UserFactory;
import userFactory.WarriorFactory;

public enum RoleType {
	
	Assassin("刺客",AssassinFactory.getInstance(),0),
	Magician("法师",MagicianFactory.getInstance(),1),
	Warrior("战士",WarriorFactory.getInstance(),2);
	
	private String description;
	private UserFactory factory;
	private int roleId;
	
	private RoleType(String description,UserFactory factory,int roleId) {
		this.description = description;
		this.factory = factory;
		this.roleId = roleId;		
	}
	
	public static UserFactory getUserFactoryById(int roleId) {
		for(RoleType r:RoleType.values()){
			if(r.roleId == roleId) {
				return r.factory;
			}
		}
		return null;
	}
	
	public static String getDescription(int roleId) {
		for(RoleType r:RoleType.values()){
			if(r.roleId == roleId) {
				return r.description;
			}
		}
		return null;
	}
	
	public static int getId(String description) {
		for(RoleType r:RoleType.values()){
			if(r.description == description) {
				return r.roleId;
			}
		}
		return -1;
	}

}
