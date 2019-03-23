package skill;

import java.io.Serializable;

import slime.Slime;
import user.User;

public class Skill implements Serializable{
	protected String skillName;
	protected String skillDesc;
	protected int skillLevel = 0;
	
	public Skill() {
		
	}
	
	
	public String getSkillName() {
		return skillName;
	}

	public String getSkillDesc() {
		return skillDesc;
	}

	public int getSkillLevel() {
		return skillLevel;
	}

	public void setSkillLevel(int skillLevel) {
		this.skillLevel = skillLevel;
	}

}
