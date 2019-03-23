package skill;

public class assassinSkill4 extends passiveSkill{
	private double crt;
	public assassinSkill4() {
		this.skillName = "黑暗奇袭";
		if (this.skillLevel==0) {
			this.skillDesc = "黑暗奇袭: 尚未学习";
			this.crt = 0;
		}else if (this.skillLevel==1) {
			this.skillDesc = "黑暗奇袭: 被动，暴击几率增加20%";
			this.crt = 20;
		}else if (this.skillLevel==2) {
			this.skillDesc = "黑暗奇袭: 被动，暴击几率增加30%";
			this.crt = 30;
		}else if (this.skillLevel==3) {
			this.skillDesc = "黑暗奇袭: 被动，暴击几率增加40%";
			this.crt = 40;
		}
	}
}
