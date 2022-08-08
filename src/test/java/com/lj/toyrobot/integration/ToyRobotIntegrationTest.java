package com.lj.toyrobot.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.lj.toyrobot.AppConstant;
import com.lj.toyrobot.ToyRobotController;
import com.lj.toyrobot.command.CommandFactory;
import com.lj.toyrobot.exception.ToyRobotException;
import com.lj.toyrobot.model.CommandContext;
import com.lj.toyrobot.model.Direction;
import com.lj.toyrobot.model.Table;
import com.lj.toyrobot.model.ToyRobot;
import com.lj.toyrobot.util.InputUtil;

public class ToyRobotIntegrationTest {
	
	private Table table;
	
	private CommandFactory commandFactory;

	private InputUtil inputUtil;
	
	@Before
	public void setup() {
		table = new Table(AppConstant.TABLE_WIDTH, AppConstant.TABLE_HEIGHT);
		commandFactory = new CommandFactory();
		inputUtil = new InputUtil();
	}
	
	@Test
	public void place_command_valid() {
		ToyRobot toyRobot = new ToyRobot();
		ToyRobotController toyRobotController = new ToyRobotController(toyRobot, table, commandFactory);
		
		String userInput = "PLACE 1,2,EAST";
		CommandContext context = inputUtil.parseInput(userInput);
		
		toyRobotController.executeCommand(context);
		
		assertNotNull(toyRobot.getPosition());
		assertEquals(1, toyRobot.getPosition().getPosX());
		assertEquals(2, toyRobot.getPosition().getPosY());
		
		assertNotNull(toyRobot.getFacing());
		assertEquals(Direction.EAST, toyRobot.getFacing());
	}
	
	@Test
	public void move_command_valid() {
		ToyRobot toyRobot = new ToyRobot();
		ToyRobotController toyRobotController = new ToyRobotController(toyRobot, table, commandFactory);
		
		String userInput = "PLACE 1,2,EAST";
		CommandContext context = inputUtil.parseInput(userInput);
		toyRobotController.executeCommand(context);
		
		userInput = "MOVE";
		context = inputUtil.parseInput(userInput);
		toyRobotController.executeCommand(context);
		
		assertNotNull(toyRobot.getPosition());
		assertEquals(2, toyRobot.getPosition().getPosX());
		assertEquals(2, toyRobot.getPosition().getPosY());
		
		assertNotNull(toyRobot.getFacing());
		assertEquals(Direction.EAST, toyRobot.getFacing());
	}
	
	@Test
	public void left_command_valid() {
		ToyRobot toyRobot = new ToyRobot();
		ToyRobotController toyRobotController = new ToyRobotController(toyRobot, table, commandFactory);
		
		String userInput = "PLACE 1,2,EAST";
		CommandContext context = inputUtil.parseInput(userInput);
		toyRobotController.executeCommand(context);
		
		userInput = "LEFT";
		context = inputUtil.parseInput(userInput);
		toyRobotController.executeCommand(context);
		
		assertNotNull(toyRobot.getPosition());
		assertEquals(1, toyRobot.getPosition().getPosX());
		assertEquals(2, toyRobot.getPosition().getPosY());
		
		assertNotNull(toyRobot.getFacing());
		assertEquals(Direction.NORTH, toyRobot.getFacing());
	}
	
	@Test
	public void right_command_valid() {
		ToyRobot toyRobot = new ToyRobot();
		ToyRobotController toyRobotController = new ToyRobotController(toyRobot, table, commandFactory);
		
		String userInput = "PLACE 1,2,EAST";
		CommandContext context = inputUtil.parseInput(userInput);
		toyRobotController.executeCommand(context);
		
		userInput = "RIGHT";
		context = inputUtil.parseInput(userInput);
		toyRobotController.executeCommand(context);
		
		assertNotNull(toyRobot.getPosition());
		assertEquals(1, toyRobot.getPosition().getPosX());
		assertEquals(2, toyRobot.getPosition().getPosY());
		
		assertNotNull(toyRobot.getFacing());
		assertEquals(Direction.SOUTH, toyRobot.getFacing());
	}
	
	@Test
	public void report_command_valid() {
		ToyRobot toyRobot = new ToyRobot();
		ToyRobotController toyRobotController = new ToyRobotController(toyRobot, table, commandFactory);
		
		String userInput = "PLACE 1,2,EAST";
		CommandContext context = inputUtil.parseInput(userInput);
		toyRobotController.executeCommand(context);
		
		userInput = "REPORT";
		context = inputUtil.parseInput(userInput);
		toyRobotController.executeCommand(context);
		
		assertNotNull(toyRobot.getPosition());
		assertEquals(1, toyRobot.getPosition().getPosX());
		assertEquals(2, toyRobot.getPosition().getPosY());
		
		assertNotNull(toyRobot.getFacing());
		assertEquals(Direction.EAST, toyRobot.getFacing());
	}
	
	@Test(expected = ToyRobotException.class)
	public void place_command_out_of_bounds() {
		ToyRobot toyRobot = new ToyRobot();
		ToyRobotController toyRobotController = new ToyRobotController(toyRobot, table, commandFactory);
		
		String userInput = "PLACE 5,-1,EAST";
		CommandContext context = inputUtil.parseInput(userInput);
		
		toyRobotController.executeCommand(context);
	}
	
	@Test(expected = ToyRobotException.class)
	public void move_command_out_of_bounds() {
		ToyRobot toyRobot = new ToyRobot();
		ToyRobotController toyRobotController = new ToyRobotController(toyRobot, table, commandFactory);
		
		String userInput = "PLACE 4,4,NORTH";
		CommandContext context = inputUtil.parseInput(userInput);
		toyRobotController.executeCommand(context);
		
		userInput = "MOVE";
		context = inputUtil.parseInput(userInput);
		toyRobotController.executeCommand(context);
	}
	
	@Test(expected = ToyRobotException.class)
	public void move_command_not_placed() {
		ToyRobot toyRobot = new ToyRobot();
		ToyRobotController toyRobotController = new ToyRobotController(toyRobot, table, commandFactory);
		
		String userInput = "MOVE";
		CommandContext context = inputUtil.parseInput(userInput);
		toyRobotController.executeCommand(context);
	}
	
	@Test(expected = ToyRobotException.class)
	public void left_command_not_placed() {
		ToyRobot toyRobot = new ToyRobot();
		ToyRobotController toyRobotController = new ToyRobotController(toyRobot, table, commandFactory);
		
		String userInput = "LEFT";
		CommandContext context = inputUtil.parseInput(userInput);
		toyRobotController.executeCommand(context);
	}
	
	@Test(expected = ToyRobotException.class)
	public void right_command_not_placed() {
		ToyRobot toyRobot = new ToyRobot();
		ToyRobotController toyRobotController = new ToyRobotController(toyRobot, table, commandFactory);
		
		String userInput = "RIGHT";
		CommandContext context = inputUtil.parseInput(userInput);
		toyRobotController.executeCommand(context);
	}
	
	@Test(expected = ToyRobotException.class)
	public void report_command_not_placed() {
		ToyRobot toyRobot = new ToyRobot();
		ToyRobotController toyRobotController = new ToyRobotController(toyRobot, table, commandFactory);
		
		String userInput = "REPORT";
		CommandContext context = inputUtil.parseInput(userInput);
		toyRobotController.executeCommand(context);
	}

}
