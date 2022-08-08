package com.lj.toyrobot.command;

import com.lj.toyrobot.AppConstant;
import com.lj.toyrobot.exception.ToyRobotException;
import com.lj.toyrobot.model.CommandContext;
import com.lj.toyrobot.model.Table;
import com.lj.toyrobot.model.ToyRobot;

public class CommandFactory {

	/**
	 * Create toy robot command.
	 * 
	 * @param context  - command type and parameters
	 * @param toyRobot - target Toy Robot of the command
	 * @param table    - target table of the command
	 * @return created command
	 */
	public Command createCommand(CommandContext context, ToyRobot toyRobot, Table table) {
		if (context == null || context.getCommandType() == null) {
			throw new ToyRobotException(AppConstant.ERROR_INCOMPLETE_PARAMTER);
		}

		switch (context.getCommandType()) {
		case PLACE:
			return new PlaceCommand(toyRobot, table, context.getPosition(), context.getDirection());
		case MOVE:
			return new MoveCommand(toyRobot, table, AppConstant.MOVE_DEFAULT_UNIT);
		case LEFT:
			return new LeftCommand(toyRobot);
		case RIGHT:
			return new RightCommand(toyRobot);
		case REPORT:
			return new ReportCommand(toyRobot);
		default:
			throw new ToyRobotException(AppConstant.ERROR_UNSUPPORTED_COMMAND);
		}
	}

}
