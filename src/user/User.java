package user;


import java.io.Serializable;
import java.util.ArrayList;

import Medicine.Medicine;
import scroll.Scroll;
import slime.Slime;
import weapon.equip;

public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	protected String userName;
	protected int roleType;
	protected String imagePath;
	
	
	//已装备武器
	protected ArrayList<equip> equipList;
	
	//背包物品
	protected ArrayList<equip> equipPackage;
	protected ArrayList<Medicine> medicinePackage;
	protected ArrayList<Scroll> scrollPackage;
	
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
	
	//力量
	protected double STR;
	
	//敏捷
	protected double AGI;
	
	//智力
	protected double INT;
	
	//闪避
	protected double AVD;
	
	//暴击
	protected double CRT;
	

	public User() {
		
	}
	
	//角色初始化
	public User(String userName,int roleType) {
		this.userName = userName;
		this.roleType = roleType;
		this.imagePath = "";
		
		this.HP = 0;
		this.MP = 0;
		this.P_ATK = 0;
		this.P_DEF = 0;
		this.M_ATK = 0;
		this.M_DEF = 0;
		this.STR = 0;
		this.AGI = 0;
		this.INT = 0;
		this.AVD = 0;
		this.CRT = 0;
		
		this.equipList = new ArrayList<equip>();
		
		this.equipPackage = new ArrayList<equip>();
		this.medicinePackage = new ArrayList<Medicine>();
		this.scrollPackage = new ArrayList<Scroll>();

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

	public double getSTR() {
		return STR;
	}

	public void setSTR(double sTR) {
		STR = sTR;
	}

	public double getAGI() {
		return AGI;
	}

	public void setAGI(double aGI) {
		AGI = aGI;
	}

	public double getINT() {
		return INT;
	}

	public void setINT(double iNT) {
		INT = iNT;
	}

	public double getAVD() {
		return AVD;
	}

	public void setAVD(double aVD) {
		AVD = aVD;
	}

	public double getCRT() {
		return CRT;
	}

	public void setCRT(double cRT) {
		CRT = cRT;
	}
	
	public double getHPDecroted() {
		double tempHP = HP;
		for(equip e :equipList){
			tempHP += e.getHP();
		}
		return tempHP;
	}

	public double getMPDecroted() {
		double tempMP = MP;
		for(equip e :equipList){
			tempMP += e.getMP();
		}
		return tempMP;
	}

	public double getP_ATKDecroted() {
		double tempP_ATK = P_ATK;
		for(equip e :equipList){
			tempP_ATK += e.getP_ATK();
		}
		return tempP_ATK;
	}

	public double getP_DEFDecroted() {
		double tempP_DEF = P_DEF;
		for(equip e :equipList){
			tempP_DEF += e.getP_DEF();
		}
		return tempP_DEF;
	}

	public double getM_ATKDecroted() {
		double tempM_ATK = M_ATK;
		for(equip e :equipList){
			tempM_ATK += e.getM_ATK();
		}
		return tempM_ATK;
	}

	public double getM_DEFDecroted() {
		double tempM_DEF = M_DEF;
		for(equip e :equipList){
			tempM_DEF += e.getM_DEF();
		}
		return tempM_DEF;
	}

	public double getSTRDecroted() {
		double tempSTR = STR;
		for(equip e :equipList){
			tempSTR += e.getSTR();
		}
		return tempSTR;
	}
	

	public double getAGIDecroted() {
		double tempAGI = AGI;
		for(equip e :equipList){
			tempAGI += e.getAGI();
		}
		return tempAGI;
	}

	public double getINTDecroted() {
		double tempINT = INT;
		for(equip e :equipList){
			tempINT += e.getINT();
		}
		return tempINT;
	}

	public double getAVDDecroted() {
		double tempAVD = AVD;
		for(equip e :equipList){
			tempAVD += e.getAVD();
		}
		return tempAVD;
	}


	public double getCRTDecroted() {
		double tempCRT = CRT;
		for(equip e :equipList){
			tempCRT += e.getCRT();
		}
		return tempCRT;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public ArrayList<equip> getEquipList() {
		return equipList;
	}

	public void setEquipList(ArrayList<equip> equipList) {
		this.equipList = equipList;
	}

	public ArrayList<equip> getEquipPackage() {
		return equipPackage;
	}

	public void setEquipPackage(ArrayList<equip> equipPackage) {
		this.equipPackage = equipPackage;
	}

	public ArrayList<Medicine> getMedicinePackage() {
		return medicinePackage;
	}

	public void setMedicinePackage(ArrayList<Medicine> medicinePackage) {
		this.medicinePackage = medicinePackage;
	}

	public ArrayList<Scroll> getScrollPackage() {
		return scrollPackage;
	}

	public void setScrollPackage(ArrayList<Scroll> scrollPackage) {
		this.scrollPackage = scrollPackage;
	}
	
	public void attack(Slime slime) {
		double damage = this.getP_ATKDecroted()-slime.getP_DEF();
		double slimeHP=slime.getHP();
		slime.setHP(damage>slimeHP?damage-slimeHP:0);
	}
}
