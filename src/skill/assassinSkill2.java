package skill;

import slime.Slime;
import user.User;

public class assassinSkill2 extends activeSkill{
	private int damageRatio;
	private int damageRatioInPoison;
	public assassinSkill2() {
		this.skillName = "��ɱ֮��";
		this.isDamageSkill = true;
		if (this.skillLevel==0) {
			this.skillDesc = "��ɱ֮��: ��δѧϰ";
		}else if (this.skillLevel==1) {
			this.skillDesc = "��ɱ֮��: ����˺�M_ATK*4�����ж�����M_ATK*6����ȴ4��ħ��40";
			this.coldTime = 4;
			this.magicCost = 40;
			this.damageRatio = 4;
			this.damageRatioInPoison = 6;
		}else if (this.skillLevel==2) {
			this.skillDesc = "��ɱ֮��: ����˺�M_ATK*5�����ж�����M_ATK*8����ȴ4��ħ��55";
			this.coldTime = 4;
			this.magicCost = 55;
			this.damageRatio = 5;
			this.damageRatioInPoison = 8;
		}else if (this.skillLevel==3) {
			this.skillDesc = "��ɱ֮��: ����˺�M_ATK*6�����ж�����M_ATK*10����ȴ4��ħ��70";
			this.coldTime = 4;
			this.magicCost = 70;
			this.damageRatio = 6;
			this.damageRatioInPoison = 10;
		}
	}
	
	@Override
	public void useSkill(User user, Slime slime) {
		user.setCurrent_MP(user.getCurrent_MP()-this.magicCost);
		boolean isInPoison = slime.getStateList()[0].getLastTime()>=1?true:false;
		double damage = 0;
		if (isInPoison) {
			damage = user.getM_ATKDecroted()*this.damageRatioInPoison;
		}else {
			damage = user.getM_ATKDecroted()*this.damageRatio;
		}
		double slimeHP = slime.getCurrent_HP();
		slime.setCurrent_HP(slimeHP>damage?slimeHP-damage:0);
	}
}
