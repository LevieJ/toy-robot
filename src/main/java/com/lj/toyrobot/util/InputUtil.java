package com.lj.toyrobot.util;

import java.util.Arrays;
import java.util.Scanner;

import com.lj.toyrobot.AppConstant;
import com.lj.toyrobot.exception.ToyRobotException;
import com.lj.toyrobot.model.CommandContext;
import com.lj.toyrobot.model.CommandType;
import com.lj.toyrobot.model.Direction;
import com.lj.toyrobot.model.Position;

public class InputUtil {

	private Scanner in;

	public InputUtil() {
		in = new Scanner(System.in);
	}

	/**
	 * Get new user input.
	 * @return new user input.
	 */
	public String nextUserInput() {
		return in.nextLine();
	}

	/**
	 * Parse user input into command context
	 * 
	 * @param strCommand - user input
	 * @return command context based on user input.
	 */
	public CommandContext parseInput(String strCommand) {

		CommandContext commandContext = new CommandContext();

		String[] commandValues = strCommand.split(" ");

		// Check if command has only 1 or 2 words
		if (commandValues.length == 0 || commandValues.length > 2)
			throw new ToyRobotException(AppConstant.ERROR_INVALID_INPUT);

		try {
			CommandType commandType = CommandType.valueOf(commandValues[0].toUpperCase());

			// Throw error when command cannot be found.
			if (commandType == null)
				throw new ToyRobotException(AppConstant.ERROR_INVALID_INPUT);

			if(CommandType.PLACE.equals(commandType)) {
				if (commandValues.length != 2) {
					throw new ToyRobotException(AppConstant.ERROR_INVALID_INPUT);
				}
				
				String[] args = commandValues[1].split(",");

				// Throw error when command arguments are not exactly 3
				if (args.length != 3) {
					throw new ToyRobotException(AppConstant.ERROR_INVALID_INPUT);
				}
				Position position = new Position(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
				Direction direction = Direction.valueOf(args[2].toUpperCase());

				commandContext.setPosition(position);
				commandContext.setDirection(direction);
			} else {
				if (commandValues.length != 1) {
					throw new ToyRobotException(AppConstant.ERROR_INVALID_INPUT);
				}
			}
			
			commandContext.setCommandType(commandType);
		} catch (IllegalArgumentException ex) {
			// Throw error when command or arguments cannot be parsed.
			throw new ToyRobotException(AppConstant.ERROR_INVALID_INPUT);
		}

		return commandContext;

	}
}
