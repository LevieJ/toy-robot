package com.lj.toyrobot.model;

public enum Direction {

	NORTH(1, 0, 1),
	EAST(2, 1, 0),
	SOUTH(3, 0, -1),
	WEST(4, -1, 0);
	
	/**
	 *  Used to calculate the left and right direction
	 */
	private int value;
	
	/**
	 * Used to calculate x movement based on direction.
	 */
	private int xMove;
	
	/**
	 * Used to calculate Y movement based on direction.
	 */
	private int yMove;
	
	private Direction(int value, int xMove, int yMove) {
		this.value = value;
		this.xMove = xMove;
		this.yMove = yMove;
	}
	
	public static Direction valueOf(int value) {
		for(Direction dir: Direction.values()) {
			if(dir.getValue() == value) {
				return dir;
			}
		}
		return null;
	}
	
	public int getValue() {
		return value;
	}

	public int getxMove() {
		return xMove;
	}

	public int getyMove() {
		return yMove;
	}
	
}
