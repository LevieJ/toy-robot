package com.lj.toyrobot.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.lj.toyrobot.exception.ToyRobotException;
import com.lj.toyrobot.model.CommandContext;
import com.lj.toyrobot.model.CommandType;
import com.lj.toyrobot.model.Direction;
import com.lj.toyrobot.util.InputUtil;

public class InputUtilTest {
	
	private InputUtil inputUtil;
	
	@Before
	public void setup() {
		inputUtil = new InputUtil();
	}
	
	@Test
	public void parse_valid_input_place() {
		String strCommand = "PLACE 0,0,NORTH";
		CommandContext context = inputUtil.parseInput(strCommand);
		
		assertEquals(CommandType.PLACE, context.getCommandType());
		
		assertNotNull(context.getPosition());
		assertEquals(0, context.getPosition().getPosX());
		assertEquals(0, context.getPosition().getPosY());
		
		assertEquals(Direction.NORTH, context.getDirection());
	}
	
	@Test
	public void parse_valid_input_move() {
		String strCommand = "MOVE";
		CommandContext context = inputUtil.parseInput(strCommand);
		
		assertEquals(CommandType.MOVE, context.getCommandType());
	}
	
	@Test
	public void parse_valid_input_left() {
		String strCommand = "LEFT";
		CommandContext context = inputUtil.parseInput(strCommand);
		
		assertEquals(CommandType.LEFT, context.getCommandType());
	}
	
	@Test
	public void parse_valid_input_right() {
		String strCommand = "RIGHT";
		CommandContext context = inputUtil.parseInput(strCommand);
		
		assertEquals(CommandType.RIGHT, context.getCommandType());
	}
	
	@Test
	public void parse_valid_input_report() {
		String strCommand = "REPORT";
		CommandContext context = inputUtil.parseInput(strCommand);
		
		assertEquals(CommandType.REPORT, context.getCommandType());
	}
	
	@Test(expected = ToyRobotException.class)
	public void parse_invalid_input_no_command() {
		String strCommand = "";
		inputUtil.parseInput(strCommand);
	}
	
	@Test(expected = ToyRobotException.class)
	public void parse_invalid_input_unknown_command() {
		String strCommand = "FLY";
		inputUtil.parseInput(strCommand);
	}
	
	@Test(expected = ToyRobotException.class)
	public void parse_invalid_input_place_no_args() {
		String strCommand = "PLACE";
		inputUtil.parseInput(strCommand);
	}
	
	@Test(expected = ToyRobotException.class)
	public void parse_invalid_input_place_invalid_args() {
		String strCommand = "PLACE A,B";
		inputUtil.parseInput(strCommand);
	}
	
	@Test(expected = ToyRobotException.class)
	public void parse_invalid_input_many_args() {
		String strCommand = "PLACE 0,0,EAST etc";
		inputUtil.parseInput(strCommand);
	}
}
