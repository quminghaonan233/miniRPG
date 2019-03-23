package skill;

import slime.Slime;
import user.User;

public class assassinSkill1 extends activeSkill{
	private int damageRatio;
	public assassinSkill1() {
		this.skillName = "½ş¶¾ÎäÆ÷";
		this.isDamageSkill = true;
		this.skillDesc = "½ş¶¾ÎäÆ÷: ÉĞÎ´Ñ§Ï°";
	}
	
	@Override
	public void useSkill(User user, Slime slime) {
		super.useSkill(user, slime);
		user.setCurrent_MP(user.getCurrent_MP()-this.magicCost);
		slime.getStateList()[0].setLastTime(this.LAST);
		slime.getStateList()[0].setDamage(user.getM_ATKDecroted()*this.damageRatio);
	}
	
	@Override
	public void setSkillLevel(int skillLevel) {
		this.skillLevel = skillLevel;
		if (this.skillLevel==0) {
			this.skillDesc = "½ş¶¾ÎäÆ÷: ÉĞÎ´Ñ§Ï°";
		}else if (this.skillLevel==1) {
			this.skillDesc = "½ş¶¾ÎäÆ÷(LV1): 4»ØºÏ³ÖĞøÉËº¦M_ATK*1¡£ÀäÈ´4¡£Ä§ºÄ10";
			this.COLD = 4;
			this.magicCost = 10;
			this.damageRatio = 1;
			this.LAST = 4;
		}else if (this.skillLevel==2) {
			this.skillDesc = "½ş¶¾ÎäÆ÷(LV2): 4»ØºÏ³ÖĞøÉËº¦M_ATK*2¡£ÀäÈ´4¡£Ä§ºÄ20";
			this.COLD = 4;
			this.magicCost = 20;
			this.damageRatio = 2;
			this.LAST = 4;
		}else if (this.skillLevel==3) {
			this.skillDesc = "½ş¶¾ÎäÆ÷(LV3): 4»ØºÏ³ÖĞøÉËº¦M_ATK*3¡£ÀäÈ´4¡£Ä§ºÄ30";
			this.COLD = 4;
			this.magicCost = 30;
			this.damageRatio = 3;
			this.LAST = 4;
		}
	}
	
}
