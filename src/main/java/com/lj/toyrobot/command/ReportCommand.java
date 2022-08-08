package com.lj.toyrobot.command;

import com.lj.toyrobot.AppConstant;
import com.lj.toyrobot.exception.ToyRobotException;
import com.lj.toyrobot.model.Direction;
import com.lj.toyrobot.model.Position;
import com.lj.toyrobot.model.ToyRobot;
import com.lj.toyrobot.util.Logger;

public class ReportCommand implements Command {
	
	/**
	 * Target toy robot of the command.
	 */
	private ToyRobot toyRobot;
	
	public ReportCommand(ToyRobot toyRobot) {
		this.toyRobot = toyRobot;
	}

	/**
	 * Print the toy robot's current position and direction.
	 */
	public void execute() {
		
		if(toyRobot == null) {
			throw new ToyRobotException(AppConstant.ERROR_INCOMPLETE_PARAMTER);
		}
		
		if(!toyRobot.isPlaced()) {
			throw new ToyRobotException(AppConstant.ERROR_NOT_PLACED);
		}
		
		Position pos = toyRobot.getPosition();
		Direction facing = toyRobot.getFacing();
		
		Logger.logMessage(AppConstant.REPORT_COMMAND_OUTPUT, pos.getPosX(), pos.getPosY(), facing.toString());
	}

	public ToyRobot getToyRobot() {
		return toyRobot;
	}
}
