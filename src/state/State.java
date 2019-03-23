package state;

import java.io.Serializable;

public class State implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;
	
	private StateType stateType;
	private int lastTime;
	private double damage;
	
	public State(StateType stateType,int lastTime,double damage) {
		this.stateType = stateType;
		this.lastTime = lastTime;
		this.damage = damage;
	}

	public int getLastTime() {
		return lastTime;
	}

	public void setLastTime(int lastTime) {
		this.lastTime = lastTime;
	}

	public StateType getStateType() {
		return stateType;
	}

	public void setStateType(StateType stateType) {
		this.stateType = stateType;
	}
	public double getDamage() {
		return damage;
	}

	public void setDamage(double damage) {
		this.damage = damage;
	}

}
