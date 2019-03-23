package user;


import java.io.Serializable;
import java.util.ArrayList;

import skill.Skill;
import slime.Slime;
import weapon.equip;
import state.State;
import state.StateType;

public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	protected String userName;
	protected int roleType;
	protected String imagePath;
	
	//已装备武器
	protected ArrayList<equip> equipList;
	
	//背包物品
	protected ArrayList<equip> packageList;

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
	
	protected double growHP;
	protected double growMP;
	protected double growP_ATK;
	protected double growP_DEF;
	protected double growM_ATK;
	protected double growM_DEF;
	
	protected Skill[] skillList = new Skill[4];
	public Skill[] getSkillList() {
		return skillList;
	}

	public void setSkillList(Skill[] skillList) {
		this.skillList = skillList;
	}

	protected double current_HP;
	protected double current_MP;
	protected State poison = new State(StateType.中毒,0,0);

	public State getPoison() {
		return poison;
	}

	public void setPoison(State poison) {
		this.poison = poison;
	}

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
		
		this.packageList = new ArrayList<equip>();

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
		tempHP += (this.getLV() - 1)*this.growHP+this.getSTRDecroted()*15;
		return tempHP;
	}

	public double getMPDecroted() {
		double tempMP = MP;
		for(equip e :equipList){
			tempMP += e.getMP();
		}
		tempMP += (this.getLV() - 1)*this.growMP+this.getINTDecroted()*6;
		return tempMP;
	}

	public double getP_ATKDecroted() {
		double tempP_ATK = P_ATK;
		for(equip e :equipList){
			tempP_ATK += e.getP_ATK();
		}
		tempP_ATK += (this.getLV() - 1)*this.growP_ATK+this.getSTRDecroted()*1;
		return tempP_ATK;
	}

	public double getP_DEFDecroted() {
		double tempP_DEF = P_DEF;
		for(equip e :equipList){
			tempP_DEF += e.getP_DEF();
		}
		tempP_DEF += (this.getLV() - 1)*this.growP_DEF+this.getSTRDecroted()*0.6;
		return tempP_DEF;
	}

	public double getM_ATKDecroted() {
		double tempM_ATK = M_ATK;
		for(equip e :equipList){
			tempM_ATK += e.getM_ATK();
		}
		tempM_ATK += (this.getLV() - 1)*this.growM_ATK+this.getINTDecroted()*1;
		return tempM_ATK;
	}

	public double getM_DEFDecroted() {
		double tempM_DEF = M_DEF;
		for(equip e :equipList){
			tempM_DEF += e.getM_DEF();
		}
		tempM_DEF += (this.getLV() - 1)*this.growM_DEF+this.getINTDecroted()*0.6;
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
		tempAVD += this.getAGIDecroted()*0.3;
		return tempAVD;
	}


	public double getCRTDecroted() {
		double tempCRT = CRT;
		for(equip e :equipList){
			tempCRT += e.getCRT();
		}
		tempCRT += this.getAGIDecroted()*0.3;
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
	
	
	public ArrayList<equip> getPackageList() {
		return packageList;
	}

	public void setPackageList(ArrayList<equip> packageList) {
		this.packageList = packageList;
	}


	
	public boolean isAlive() {
		if((int)this.current_HP>0) {
			return true;
		}
		return false;
	}
	
	public void attack(Slime slime) {
		double damage = this.getP_ATKDecroted()-slime.getP_DEF();
		double slimeHP=slime.getCurrent_HP();
		slime.setCurrent_HP(slimeHP>damage?slimeHP-damage:0);
	}
	
}
