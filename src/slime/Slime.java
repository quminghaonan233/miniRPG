package slime;

import user.User;

public class Slime {
	protected String imagePath;
	protected int SlimeType;
	
	protected String slimeName;

	//生命
	protected double HP;
	
	//魔法
	protected double MP;
	
	//等级
	protected int LV;
	
	//经验
	protected double EXP;
	
	//物理攻击
	protected double P_ATK;
	
	//物理防御
	protected double P_DEF;
	
	//魔法攻击
	protected double M_ATK;
	
	//魔法防御
	protected double M_DEF;
	
	protected double current_HP;
	protected double current_MP;
	
	
	public double getCurrent_HP() {
		return current_HP;
	}
	public void setCurrent_HP(double current_HP) {
		this.current_HP = current_HP;
	}
	public double getCurrent_MP() {
		return current_MP;
	}
	public void setCurrent_MP(double current_MP) {
		this.current_MP = current_MP;
	}
	public String getSlimeName() {
		return "史莱姆";
	}
	public double getHP() {
		return HP;
	}
	public void setHP(double hP) {
		HP = hP;
	}
	public double getMP() {
		return MP;
	}
	public void setMP(double mP) {
		MP = mP;
	}
	public int getLV() {
		return LV;
	}
	public void setLV(int lV) {
		LV = lV;
	}
	public double getEXP() {
		return EXP;
	}
	public void setEXP(double eXP) {
		EXP = eXP;
	}
	public double getP_ATK() {
		return P_ATK;
	}
	public void setP_ATK(double p_ATK) {
		P_ATK = p_ATK;
	}
	public double getP_DEF() {
		return P_DEF;
	}
	public void setP_DEF(double p_DEF) {
		P_DEF = p_DEF;
	}
	public double getM_ATK() {
		return M_ATK;
	}
	public void setM_ATK(double m_ATK) {
		M_ATK = m_ATK;
	}
	public double getM_DEF() {
		return M_DEF;
	}
	public void setM_DEF(double m_DEF) {
		M_DEF = m_DEF;
	}
	public int getSlimeType() {
		return SlimeType;
	}
	public void setSlimeType(int slimeType) {
		SlimeType = slimeType;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	public void equipmentBuilder() {
		
	}
	
	public int[] move(int slimeX,int slimeY,int userX,int userY) {
		int[] result = new int[2];
		if(Math.abs(slimeX - userX) >= Math.abs(slimeY-userY)) {
			if(slimeX < userX) {
				result[0] = slimeX + 1;
			}
			else {
				result[0] = slimeX - 1;
			}
			result[1] = slimeY;
		}
		else {
			if(slimeY < userY) {
				result[1] = slimeY + 1;
			}
			else {
				result[1] = slimeY - 1;
			}
			result[0] = slimeX;
		}	
		
		return result;
	}
	
	public boolean isAlive() {
		if((int)this.current_HP>0) {
			return true;
		}
		return false;
	}
	
	public void attack(User user) {
		double damage = this.getP_ATK()-user.getP_DEF();
		double userHP=user.getCurrent_HP();
		user.setCurrent_HP(userHP>damage?userHP-damage:0);
	}
}
