package skill;

public class assassinSkill4 extends passiveSkill{
	private double crt;
	public assassinSkill4() {
		this.skillName = "黑暗奇袭";
		this.skillDesc = "黑暗奇袭: 尚未学习";
	}
	
	@Override
	public void setSkillLevel(int skillLevel) {
		this.skillLevel = skillLevel;
		if (this.skillLevel==0) {
			this.skillDesc = "黑暗奇袭: 尚未学习";
			this.crt = 0;
		}else if (this.skillLevel==1) {
			this.skillDesc = "黑暗奇袭(LV1): 被动，暴击几率增加20%";
			this.crt = 20;
		}else if (this.skillLevel==2) {
			this.skillDesc = "黑暗奇袭(LV2): 被动，暴击几率增加35%";
			this.crt = 30;
		}
	}
}
