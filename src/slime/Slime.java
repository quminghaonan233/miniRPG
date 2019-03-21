package slime;

public class Slime {
	protected String imagePath;
	protected int SlimeType;
	
	protected String slimeName;

	//生命
	protected double HP;
	
	//魔法
	protected double MP;
	
	//等级
	protected double LV;
	
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
	public double getLV() {
		return LV;
	}
	public void setLV(double lV) {
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
}
