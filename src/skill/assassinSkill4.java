package skill;

public class assassinSkill4 extends passiveSkill{
	private double crt;
	public assassinSkill4() {
		this.skillName = "�ڰ���Ϯ";
		if (this.skillLevel==0) {
			this.skillDesc = "�ڰ���Ϯ: ��δѧϰ";
			this.crt = 0;
		}else if (this.skillLevel==1) {
			this.skillDesc = "�ڰ���Ϯ: ������������������20%";
			this.crt = 20;
		}else if (this.skillLevel==2) {
			this.skillDesc = "�ڰ���Ϯ: ������������������30%";
			this.crt = 30;
		}else if (this.skillLevel==3) {
			this.skillDesc = "�ڰ���Ϯ: ������������������40%";
			this.crt = 40;
		}
	}
}
