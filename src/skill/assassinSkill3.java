package skill;

public class assassinSkill3 extends passiveSkill{
	private double avd;
	public assassinSkill3() {
		this.skillName = "��Ӱ����";
		if (this.skillLevel==0) {
			this.skillDesc = "��Ӱ����: ��δѧϰ";
			this.avd = 0;
		}else if (this.skillLevel==1) {
			this.skillDesc = "��Ӱ����: ���������ܼ�������20%";
			this.avd = 20;
		}else if (this.skillLevel==2) {
			this.skillDesc = "��Ӱ����: ���������ܼ�������30%";
			this.avd = 30;
		}else if (this.skillLevel==3) {
			this.skillDesc = "��Ӱ����: ���������ܼ�������40%";
			this.avd = 40;
		}
	}
	
}