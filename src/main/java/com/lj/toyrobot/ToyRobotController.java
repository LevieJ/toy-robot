package com.lj.toyrobot;

import com.lj.toyrobot.command.Command;
import com.lj.toyrobot.command.CommandFactory;
import com.lj.toyrobot.model.CommandContext;
import com.lj.toyrobot.model.Table;
import com.lj.toyrobot.model.ToyRobot;

/**
 * Controls Toy Robot based on input commands.
 * 
 * @author levie
 *
 */
public class ToyRobotController {
	
	/**
	 * Toy robot to control.
	 */
	private ToyRobot toyRobot;
	
	/**
	 * Table to which toy robot will navigate.
	 */
	private Table table;
	
	/**
	 * Factory instance for command creation.
	 */
	private CommandFactory commandFactory;
	
	public ToyRobotController(ToyRobot toyRobot, Table table, CommandFactory commandFactory) {
		this.toyRobot = toyRobot;
		this.table = table;
		this.commandFactory = commandFactory;
	}
	
	/**
	 * Execute a command based on the given input.
	 * 
	 * @param context
	 */
	public void executeCommand(CommandContext context) {
		Command command = commandFactory.createCommand(context, toyRobot, table);
		command.execute();
	}

}
