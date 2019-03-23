package skill;

public class assassinSkill3 extends passiveSkill{
	private double avd;
	public assassinSkill3() {
		this.skillName = "幻影迷踪";
		this.skillDesc = "幻影迷踪: 尚未学习";
	}
	
	@Override
	public void setSkillLevel(int skillLevel) {
		this.skillLevel = skillLevel;
		if (this.skillLevel==0) {
			this.skillDesc = "幻影迷踪: 尚未学习";
			this.avd = 0;
		}else if (this.skillLevel==1) {
			this.skillDesc = "幻影迷踪(LV1): 被动，闪避几率增加20%";
			this.avd = 20;
		}else if (this.skillLevel==2) {
			this.skillDesc = "幻影迷踪(LV2): 被动，闪避几率增加30%";
			this.avd = 30;
		}else if (this.skillLevel==3) {
			this.skillDesc = "幻影迷踪(LV3): 被动，闪避几率增加40%";
			this.avd = 40;
		}
	}
	
}
