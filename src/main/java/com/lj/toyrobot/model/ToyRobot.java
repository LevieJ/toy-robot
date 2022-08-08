package com.lj.toyrobot.model;

public class ToyRobot {
	
	private Position position;
	
	private Direction facing;
	
	/**
	 * Check if toy robot position and direction are already set.
	 * @return true if already set, false if not
	 */
	public boolean isPlaced() {
		return position != null && facing != null;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Direction getFacing() {
		return facing;
	}

	public void setFacing(Direction facing) {
		this.facing = facing;
	}
	
	

}
