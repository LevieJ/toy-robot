package com.lj.toyrobot.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.lj.toyrobot.AppConstant;
import com.lj.toyrobot.command.Command;
import com.lj.toyrobot.command.CommandFactory;
import com.lj.toyrobot.command.LeftCommand;
import com.lj.toyrobot.command.MoveCommand;
import com.lj.toyrobot.command.PlaceCommand;
import com.lj.toyrobot.command.ReportCommand;
import com.lj.toyrobot.command.RightCommand;
import com.lj.toyrobot.exception.ToyRobotException;
import com.lj.toyrobot.model.CommandContext;
import com.lj.toyrobot.model.CommandType;
import com.lj.toyrobot.model.Direction;
import com.lj.toyrobot.model.Position;
import com.lj.toyrobot.model.Table;
import com.lj.toyrobot.model.ToyRobot;


public class CommandFactoryTest {
	
	private ToyRobot toyRobot;
	
	private Table table;
	
	private CommandFactory commanFactory;
	
	@Before
	public void setup() {
		toyRobot = new ToyRobot();
		table = new Table(5,5);
		commanFactory = new CommandFactory();
	}
	
	@Test
	public void create_place_command() {
		Position position = new Position(1,1);
		Direction direction = Direction.NORTH;
		
		CommandContext context = new CommandContext();
		context.setCommandType(CommandType.PLACE);
		context.setPosition(position);
		context.setDirection(direction);
		
		Command command = commanFactory.createCommand(context, toyRobot, table);
		
		assertTrue(command instanceof PlaceCommand);
		
		PlaceCommand placeCommand = (PlaceCommand) command;	
		assertNotNull(placeCommand.getToyRobot());
		assertNotNull(placeCommand.getTable());
		assertNotNull(placeCommand.getNewPosition());
		assertNotNull(placeCommand.getNewDirection());
	}
	
	@Test
	public void create_move_command() {
		
		CommandContext context = new CommandContext();
		context.setCommandType(CommandType.MOVE);
		
		Command command = commanFactory.createCommand(context, toyRobot, table);
		
		assertTrue(command instanceof MoveCommand);
		
		MoveCommand moveCommand = (MoveCommand) command;
		assertNotNull(moveCommand.getToyRobot());
		assertNotNull(moveCommand.getTable());
		assertEquals(moveCommand.getUnit(), AppConstant.MOVE_DEFAULT_UNIT);
	}
	
	@Test
	public void create_left_command() {
		
		CommandContext context = new CommandContext();
		context.setCommandType(CommandType.LEFT);
		
		Command command = commanFactory.createCommand(context, toyRobot, table);
		
		assertTrue(command instanceof LeftCommand);
		
		LeftCommand leftCommand = (LeftCommand) command;
		assertNotNull(leftCommand.getToyRobot());
	}
	
	@Test
	public void create_right_command() {
		
		CommandContext context = new CommandContext();
		context.setCommandType(CommandType.RIGHT);
		
		Command command = commanFactory.createCommand(context, toyRobot, table);
		
		assertTrue(command instanceof RightCommand);
		
		RightCommand rightCommand = (RightCommand) command;
		assertNotNull(rightCommand.getToyRobot());
	}
	
	@Test
	public void create_report_command() {
		
		CommandContext context = new CommandContext();
		context.setCommandType(CommandType.REPORT);
		
		Command command = commanFactory.createCommand(context, toyRobot, table);
		
		assertTrue(command instanceof ReportCommand);
		
		ReportCommand reportCommand = (ReportCommand) command;
		assertNotNull(reportCommand.getToyRobot());
	}
	
	@Test(expected = ToyRobotException.class)
	public void create_command_with_incomplete_paramter() {
		
		commanFactory.createCommand(null, toyRobot, table);
	}
	
	@Test(expected = ToyRobotException.class)
	public void create_command_with_unsupported_type() {
		
		CommandContext context = new CommandContext();
		context.setCommandType(CommandType.EXIT);
		commanFactory.createCommand(context, toyRobot, table);
	}


}
