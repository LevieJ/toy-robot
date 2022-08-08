package com.lj.toyrobot.command;

import com.lj.toyrobot.AppConstant;
import com.lj.toyrobot.exception.ToyRobotException;
import com.lj.toyrobot.model.Direction;
import com.lj.toyrobot.model.Position;
import com.lj.toyrobot.model.Table;
import com.lj.toyrobot.model.ToyRobot;

public class PlaceCommand implements Command {
	
	/**
	 * Target toy robot of the command.
	 */
	private ToyRobot toyRobot;
	
	/**
	 * Table where the toy robot will be placed in.
	 */
	private Table table;
	
	/**
	 * New position of toy robot in the table.
	 */
	private Position newPosition;
	
	/** 
	 * New direction where the toy robot will be facing.
	 */
	private Direction newDirection;
	
	public PlaceCommand(ToyRobot toyRobot, Table table, Position newPosition, Direction newDirection) {
		this.toyRobot = toyRobot;
		this.table = table;
		this.newPosition = newPosition;
		this.newDirection = newDirection;
	}

	/**
	 * Place the toy robot to the new position in the table and face it to the new direction.
	 */
	public void execute() {
		
		if(toyRobot == null || table == null || newPosition == null || newDirection == null) {
			throw new ToyRobotException(AppConstant.ERROR_INCOMPLETE_PARAMTER);
		}
		
		// Check if new position is within the bounds of target table.
		if(!table.isWithinBounds(newPosition.getPosX(), newPosition.getPosY())) {
			throw new ToyRobotException(AppConstant.ERROR_WRONG_POSITION_PLACE);
		}
		
		toyRobot.setPosition(newPosition);
		toyRobot.setFacing(newDirection);
	}

	public ToyRobot getToyRobot() {
		return toyRobot;
	}

	public Table getTable() {
		return table;
	}

	public Position getNewPosition() {
		return newPosition;
	}

	public Direction getNewDirection() {
		return newDirection;
	}

}
