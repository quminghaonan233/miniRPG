package skill;

public class assassinSkill4 extends passiveSkill{
	private double crt;
	public assassinSkill4() {
		this.skillName = "�ڰ���Ϯ";
		this.skillDesc = "�ڰ���Ϯ: ��δѧϰ";
	}
	
	@Override
	public void setSkillLevel(int skillLevel) {
		this.skillLevel = skillLevel;
		if (this.skillLevel==0) {
			this.skillDesc = "�ڰ���Ϯ: ��δѧϰ";
			this.crt = 0;
		}else if (this.skillLevel==1) {
			this.skillDesc = "�ڰ���Ϯ(LV1): ������������������20%";
			this.crt = 20;
		}else if (this.skillLevel==2) {
			this.skillDesc = "�ڰ���Ϯ(LV2): ������������������35%";
			this.crt = 30;
		}
	}
}
