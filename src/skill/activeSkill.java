package skill;

import slime.Slime;
import user.User;

public class activeSkill extends Skill{
	protected int coldTime;
	protected int lastTime;
	protected int magicCost;
	protected boolean isDamageSkill;
	
	public boolean isDamageSkill() {
		return isDamageSkill;
	}

	public void setDamageSkill(boolean isDamageSkill) {
		this.isDamageSkill = isDamageSkill;
	}

	public int getMagicCost() {
		return magicCost;
	}

	public void setMagicCost(int magicCost) {
		this.magicCost = magicCost;
	}

	public int getColdTime() {
		return coldTime;
	}

	public void setColdTime(int coldTime) {
		this.coldTime = coldTime;
	}

	public int getLastTime() {
		return lastTime;
	}

	public void setLastTime(int lastTime) {
		this.lastTime = lastTime;
	}

	public void useSkill(User user, Slime slime) {
		
	}
	
}
