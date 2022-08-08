package com.lj.toyrobot.model;

public class Table {
	
	private int width;
	
	private int heigth;
	
	public Table(int width, int heigth) {
		this.width = width;
		this.heigth = heigth;
	}
	
	/**
	 * Check if X and Y position is within bounds of the table.
	 * 
	 * @param posX - X position to check.
	 * @param posY - Y position to check.
	 * @return true if within bounds, false if not
	 */
	public boolean isWithinBounds(int posX, int posY) {
		return posX >= 0 &&
			   posX < width && 
			   posY >= 0 && 
			   posY < heigth;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeigth() {
		return heigth;
	}

	public void setHeigth(int heigth) {
		this.heigth = heigth;
	}
	
}
