package slime;

import java.util.List;
import java.util.Random;

import Medicine.Medicine;
import state.State;
import state.StateType;
import user.User;
import weapon.equip;

public class Slime {
	protected String imagePath;
	protected int SlimeType;
	
	protected String slimeName;
	
	protected int posX;
	protected int posY;

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
	
	protected equip equip;
	
	protected double growHP;
	protected double growMP;
	protected double growP_ATK;
	protected double growP_DEF;
	protected double growM_ATK;
	protected double growM_DEF;
	
	protected double current_HP;
	protected double current_MP;
	protected State[] stateList = {new State(StateType.中毒,0,0),new State(StateType.沉默,0,0),new State(StateType.眩晕,0,0)};
	
	public Slime() {
		Random rand=new Random();
		int randomInt = rand.nextInt(1000);
	}
	
	public double getCurrent_HP() {
		return current_HP;
	}
	public State[] getStateList() {
		return stateList;
	}
	public void setStateList(State[] stateList) {
		this.stateList = stateList;
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
	
	public int getPosX() {
		return posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	public equip getEquip() {
		return equip;
	}

	public void setEquip(equip equip) {
		this.equip = equip;
	}
	
	public void move(int userX,int userY) {
		Random r = new Random();
		if(posX < userX) {
			this.posX = posX + r.nextInt(2);
		}
		else if(posX > userX){
			this.posX = posX - r.nextInt(2);
		}
		if(posY < userY) {
			this.posY = posY + r.nextInt(2);
		}
		else if(posY > userY) {
			this.posY = posY - r.nextInt(2);
		}	
		
	}
	
	public double getHPDecroted() {
		double tempHP = HP;
		tempHP += (this.getLV() - 1)*this.growHP;
		return tempHP;
	}
	
	public double getMPDecroted() {
		double tempMP = MP;
		tempMP += (this.getLV() - 1)*this.growMP;
		return tempMP;
	}
	
	public double getP_ATKDecroted() {
		double tempP_ATK = P_ATK;
		tempP_ATK += (this.getLV() - 1)*this.growP_ATK;
		return tempP_ATK;
	}

	public double getP_DEFDecroted() {
		double tempP_DEF = P_DEF;
		tempP_DEF += (this.getLV() - 1)*this.growP_DEF;
		return tempP_DEF;
	}

	public double getM_ATKDecroted() {
		double tempM_ATK = M_ATK;
		tempM_ATK += (this.getLV() - 1)*this.growM_ATK;
		return tempM_ATK;
	}

	public double getM_DEFDecroted() {
		double tempM_DEF = M_DEF;
		tempM_DEF += (this.getLV() - 1)*this.growM_DEF;
		return tempM_DEF;
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
