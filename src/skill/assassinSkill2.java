package skill;

import slime.Slime;
import user.User;

public class assassinSkill2 extends activeSkill{
	private int damageRatio;
	private int damageRatioInPoison;
	public assassinSkill2() {
		this.skillName = "°µÉ±Ö®½£";
		this.isDamageSkill = true;
		if (this.skillLevel==0) {
			this.skillDesc = "°µÉ±Ö®½£: ÉÐÎ´Ñ§Ï°";
		}else if (this.skillLevel==1) {
			this.skillDesc = "°µÉ±Ö®½£: Ôì³ÉÉËº¦M_ATK*4£¬ÈôÖÐ¶¾£¬ÔòM_ATK*6¡£ÀäÈ´4¡£Ä§ºÄ40";
			this.coldTime = 4;
			this.magicCost = 40;
			this.damageRatio = 4;
			this.damageRatioInPoison = 6;
		}else if (this.skillLevel==2) {
			this.skillDesc = "°µÉ±Ö®½£: Ôì³ÉÉËº¦M_ATK*5£¬ÈôÖÐ¶¾£¬ÔòM_ATK*8¡£ÀäÈ´4¡£Ä§ºÄ55";
			this.coldTime = 4;
			this.magicCost = 55;
			this.damageRatio = 5;
			this.damageRatioInPoison = 8;
		}else if (this.skillLevel==3) {
			this.skillDesc = "°µÉ±Ö®½£: Ôì³ÉÉËº¦M_ATK*6£¬ÈôÖÐ¶¾£¬ÔòM_ATK*10¡£ÀäÈ´4¡£Ä§ºÄ70";
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
