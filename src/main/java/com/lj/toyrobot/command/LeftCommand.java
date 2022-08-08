package com.lj.toyrobot.command;

import java.util.Arrays;
import java.util.Comparator;

import com.lj.toyrobot.AppConstant;
import com.lj.toyrobot.exception.ToyRobotException;
import com.lj.toyrobot.model.Direction;
import com.lj.toyrobot.model.ToyRobot;

public class LeftCommand implements Command {
	
	/**
	 * Target toy robot of the command.
	 */
	private ToyRobot toyRobot;
	
	public LeftCommand(ToyRobot toyRobot) {
		this.toyRobot = toyRobot;
	}

	/**
	 * Turn the facing direction of toy robot to the left.
	 */
	public void execute() {
		
		if(toyRobot == null ) {
			throw new ToyRobotException(AppConstant.ERROR_INCOMPLETE_PARAMTER);
		}
		
		if(!toyRobot.isPlaced()) {
			throw new ToyRobotException(AppConstant.ERROR_NOT_PLACED);
		}
		
		int oldDirValue = toyRobot.getFacing().getValue();
	
		// Use the current enum Direction's value to calculate the left direction.
		int newDirValue = oldDirValue - 1; 
		if(newDirValue == 0) {
			// set new direction to max value when computation result is 0.
			newDirValue = Arrays.stream(Direction.values()).map(dir -> dir.getValue()).max(Comparator.naturalOrder()).get();
		}
		
		Direction newDirection = Direction.valueOf(newDirValue);
		
		toyRobot.setFacing(newDirection);
	}

	public ToyRobot getToyRobot() {
		return toyRobot;
	}

}
