package skill;

import slime.Slime;
import user.User;

public class assassinSkill1 extends activeSkill{
	private int damageRatio;
	public assassinSkill1() {
		this.skillName = "��������";
		this.isDamageSkill = true;
		if (this.skillLevel==0) {
			this.skillDesc = "��������: ��δѧϰ";
			System.out.println(this.skillLevel);
		}else if (this.skillLevel==1) {
			this.skillDesc = "��������: 4�غϳ����˺�M_ATK*1����ȴ4��ħ��10";
			this.coldTime = 4;
			this.magicCost = 10;
			this.damageRatio = 1;
			this.lastTime = 4;
		}else if (this.skillLevel==2) {
			this.skillDesc = "��������: 4�غϳ����˺�M_ATK*2����ȴ4��ħ��20";
			this.coldTime = 4;
			this.magicCost = 20;
			this.damageRatio = 2;
			this.lastTime = 4;
		}else if (this.skillLevel==3) {
			this.skillDesc = "��������: 4�غϳ����˺�M_ATK*3����ȴ4��ħ��30";
			this.coldTime = 4;
			this.magicCost = 30;
			this.damageRatio = 3;
			this.lastTime = 4;
		}
	}
	
	@Override
	public void useSkill(User user, Slime slime) {
		user.setCurrent_MP(user.getCurrent_MP()-this.magicCost);
		slime.getStateList()[0].setLastTime(this.lastTime);
		slime.getStateList()[0].setDamage(user.getM_ATKDecroted()*this.damageRatio);
	}
	
}
