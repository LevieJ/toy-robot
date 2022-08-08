package com.lj.toyrobot.command;

import java.util.Arrays;
import java.util.Comparator;

import com.lj.toyrobot.AppConstant;
import com.lj.toyrobot.exception.ToyRobotException;
import com.lj.toyrobot.model.Direction;
import com.lj.toyrobot.model.ToyRobot;

public class RightCommand implements Command {
	
	/**
	 * Target toy robot of the command.
	 */
	private ToyRobot toyRobot;
	
	public RightCommand(ToyRobot toyRobot) {
		this.toyRobot = toyRobot;
	}

	/**
	 * Turn the facing direction of toy robot to the right.
	 */
	public void execute() {
		
		if(toyRobot == null) {
			throw new ToyRobotException(AppConstant.ERROR_INCOMPLETE_PARAMTER);
		}
		
		if(!toyRobot.isPlaced()) {
			throw new ToyRobotException(AppConstant.ERROR_NOT_PLACED);
		}
		
		int oldDirValue = toyRobot.getFacing().getValue();
		
		// Use the current enum Direction's value to calculate the left direction.
		int newDirValue = oldDirValue + 1;
		int maxValue = Arrays.stream(Direction.values()).map(dir -> dir.getValue()).max(Comparator.naturalOrder()).get();
		if(newDirValue > maxValue) {
			// set new direction to 1 when computation result is greater than the max direction value.
			newDirValue = 1;
		}
		
		Direction newDirection = Direction.valueOf(newDirValue);
		
		toyRobot.setFacing(newDirection);
	}

	public ToyRobot getToyRobot() {
		return toyRobot;
	}
	
}
