package com.lj.toyrobot;

import com.lj.toyrobot.command.CommandFactory;
import com.lj.toyrobot.exception.ToyRobotException;
import com.lj.toyrobot.model.CommandContext;
import com.lj.toyrobot.model.CommandType;
import com.lj.toyrobot.model.Table;
import com.lj.toyrobot.model.ToyRobot;
import com.lj.toyrobot.util.InputUtil;
import com.lj.toyrobot.util.Logger;

public class ToyRobotApplication {

	public static void main(String[] args) {
		ToyRobotApplication application = new ToyRobotApplication();
		application.start();

	}

	public void start() {
		// Initialization
		Table table = new Table(AppConstant.TABLE_WIDTH, AppConstant.TABLE_HEIGHT);
		ToyRobotController controller = new ToyRobotController(new ToyRobot(), table, new CommandFactory());

		InputUtil inputUtil = new InputUtil();
		String userInput = null;

		// Welcome message
		printWelcomeMessage(table);

		// Command execution loop
		boolean exitCommandLoop = false;
		while (!exitCommandLoop) {
			try {
				// Get user input
				userInput = inputUtil.nextUserInput();

				if (CommandType.EXIT.toString().equalsIgnoreCase(userInput)) {
					exitCommandLoop = true;
					continue;
				}

				// Parse user input into command context
				CommandContext commandContext = inputUtil.parseInput(userInput);
				// Execute command
				controller.executeCommand(commandContext);

			} catch (ToyRobotException ex) {
				Logger.logError(ex.getMessage());
			}
		}
		Logger.logMessage("----------- End --------------");
	}
	

	private void printWelcomeMessage(Table table) {
		Logger.logMessage("---- Toy Robot Aplication ----");
		Logger.logMessage("Available Commands: ");
		Logger.logMessage("PLACE X(0-%d),Y(0-%d),NORTH/EAST/SOUTH/WEST (ex: PLACE 0,0,North)",
				table.getWidth() - 1, table.getHeigth() - 1);
		Logger.logMessage("MOVE");
		Logger.logMessage("LEFT");
		Logger.logMessage("RIGHT");
		Logger.logMessage("REPORT");
		Logger.logMessage("EXIT");
		Logger.logMessage("------------------------------");
	}

}
