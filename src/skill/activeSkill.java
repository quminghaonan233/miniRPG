package skill;

import slime.Slime;
import user.User;

public class activeSkill extends Skill{
	protected int COLD;
	protected int coldTime;
	protected int LAST;
	protected int lastTime;
	protected int magicCost;
	protected boolean isDamageSkill;
	
	public activeSkill(){
		this.coldTime = 0;
	}
	
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
	
	public int getCOLD() {
		return COLD;
	}

	public int getLAST() {
		return LAST;
	}

	public void useSkill(User user, Slime slime) {
		this.coldTime = this.COLD;
	}
	
}
