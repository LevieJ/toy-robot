package com.lj.toyrobot.command;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.lj.toyrobot.command.LeftCommand;
import com.lj.toyrobot.exception.ToyRobotException;
import com.lj.toyrobot.model.Direction;
import com.lj.toyrobot.model.Position;
import com.lj.toyrobot.model.ToyRobot;


public class LeftCommandTest {
	
	@Test
	public void execute_with_correct_left_north() {
		ToyRobot toyRobot = new ToyRobot();
		toyRobot.setPosition(new Position(2, 2));
		toyRobot.setFacing(Direction.NORTH);
		
		LeftCommand command = new LeftCommand(toyRobot);
		command.execute();
		
		assertEquals(Direction.WEST, toyRobot.getFacing());
	}
	
	@Test
	public void execute_with_correct_left_east() {
		ToyRobot toyRobot = new ToyRobot();
		toyRobot.setPosition(new Position(2, 2));
		toyRobot.setFacing(Direction.EAST);
		
		LeftCommand command = new LeftCommand(toyRobot);
		command.execute();
		
		assertEquals(Direction.NORTH, toyRobot.getFacing());
	}
	
	@Test
	public void execute_with_correct_left_south() {
		ToyRobot toyRobot = new ToyRobot();
		toyRobot.setPosition(new Position(2, 2));
		toyRobot.setFacing(Direction.SOUTH);
		
		LeftCommand command = new LeftCommand(toyRobot);
		command.execute();
		
		assertEquals(Direction.EAST, toyRobot.getFacing());
	}
	
	@Test
	public void execute_with_correct_left_west() {
		ToyRobot toyRobot = new ToyRobot();
		toyRobot.setPosition(new Position(2, 2));
		toyRobot.setFacing(Direction.WEST);
		
		LeftCommand command = new LeftCommand(toyRobot);
		command.execute();
		
		assertEquals(Direction.SOUTH, toyRobot.getFacing());
	}

	
	@Test(expected = ToyRobotException.class)
	public void execute_with_incomplete_parameter() {
		
		LeftCommand command = new LeftCommand(null);
		command.execute();
	}
	
	@Test(expected = ToyRobotException.class)
	public void execute_with_toyrobot_not_placed() {
		ToyRobot toyRobot = new ToyRobot();
		
		LeftCommand command = new LeftCommand(toyRobot);
		command.execute();
	}
	
	
}
