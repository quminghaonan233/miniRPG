package weapon;

public class equip {
	
	protected int num;

	//����
	protected double HP;
	
	//ħ��
	protected double MP;
		
	//������
	protected double P_ATK;
		
	//�������
	protected double P_DEF;
		
	//ħ������
	protected double M_ATK;
		
	//ħ������
	protected double M_DEF;
		
	//����
	protected double STR;
		
	//����
	protected double AGI;
		
	//����
	protected double INT;
		
	//����
	protected double AVD;
		
	//����
	protected double CRT;
	
	

	public equip() {
		this.num = 0;
		
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
	}
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
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
}
