package user;


import java.io.Serializable;

public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	protected String userName;
	protected int roleType;
	protected String imagePath;
	
	//½ÇÉ«³õÊ¼»¯
	public User(String userName,int roleType) {
		this.userName = userName;
		this.roleType = roleType;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getRoleType() {
		return roleType;
	}

	public void setRoleType(int roleType) {
		this.roleType = roleType;
	}
	
}
