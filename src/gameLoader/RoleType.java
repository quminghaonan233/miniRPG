package gameLoader;

public enum RoleType {
	
	Assassin("�̿�",0),
	Magician("��ʦ",1),
	Warrior("սʿ",2);
	
	private String description;
	private int roleId;
	
	private RoleType(String description,int roleId) {
		this.description = description;
		this.roleId = roleId;		
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
