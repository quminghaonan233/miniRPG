package state;

import user.User;

public class State {
	private StateType stateType;
	private int lastTime;
	
	public State(int lastTime) {
		this.stateType = stateType;
		this.lastTime = lastTime;
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

}
