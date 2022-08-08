package com.lj.toyrobot.command;

import com.lj.toyrobot.AppConstant;
import com.lj.toyrobot.exception.ToyRobotException;
import com.lj.toyrobot.model.Position;
import com.lj.toyrobot.model.Table;
import com.lj.toyrobot.model.ToyRobot;

public class MoveCommand implements Command {
	
	/**
	 * Target toy robot of the command.
	 */
	private ToyRobot toyRobot;
	
	/**
	 * Table where the toy robot is located.
	 */
	private Table table;
	
	/**
	 * Number of unit for the movement.
	 */
	private int unit;
	
	public MoveCommand(ToyRobot toyRobot, Table table, int unit) {
		this.toyRobot = toyRobot;
		this.table = table;
		this.unit = unit;
	}

	/**
	 * Move the toy robot position based on the direction it is facing.
	 */
	public void execute() {
		
		if(toyRobot == null || table == null || unit == 0) {
			throw new ToyRobotException(AppConstant.ERROR_INCOMPLETE_PARAMTER);
		}
		
		if(!toyRobot.isPlaced()) {
			throw new ToyRobotException(AppConstant.ERROR_NOT_PLACED);
		}
		
		Position oldPosition = toyRobot.getPosition();
		
		// Calculate the new X and Y position of toy robot based on current facing direction.
		int newPosY = (toyRobot.getFacing().getyMove() * unit) + oldPosition.getPosY();
		int newPosX = (toyRobot.getFacing().getxMove() * unit) + oldPosition.getPosX();

		// throw error when new position will be out of bounds of the table.
		if(!table.isWithinBounds(newPosX, newPosY)) {
			throw new ToyRobotException(AppConstant.ERROR_WRONG_POSITION_MOVE);
		}
		
		toyRobot.setPosition(new Position(newPosX, newPosY));
		
	}

	public ToyRobot getToyRobot() {
		return toyRobot;
	}

	public Table getTable() {
		return table;
	}

	public int getUnit() {
		return unit;
	}
}
