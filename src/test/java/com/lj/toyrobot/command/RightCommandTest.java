package com.lj.toyrobot.command;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.lj.toyrobot.command.RightCommand;
import com.lj.toyrobot.exception.ToyRobotException;
import com.lj.toyrobot.model.Direction;
import com.lj.toyrobot.model.Position;
import com.lj.toyrobot.model.ToyRobot;


public class RightCommandTest {

	@Test
	public void execute_with_correct_output() {
		ToyRobot toyRobot = new ToyRobot();
		toyRobot.setPosition(new Position(2, 2));
		toyRobot.setFacing(Direction.NORTH);
		
		RightCommand command = new RightCommand(toyRobot);
		command.execute();
		
		assertEquals(Direction.EAST, toyRobot.getFacing());
	}
	
	@Test
	public void execute_with_correct_right_east() {
		ToyRobot toyRobot = new ToyRobot();
		toyRobot.setPosition(new Position(2, 2));
		toyRobot.setFacing(Direction.EAST);
		
		RightCommand command = new RightCommand(toyRobot);
		command.execute();
		
		assertEquals(Direction.SOUTH, toyRobot.getFacing());
	}
	
	@Test
	public void execute_with_correct_right_south() {
		ToyRobot toyRobot = new ToyRobot();
		toyRobot.setPosition(new Position(2, 2));
		toyRobot.setFacing(Direction.SOUTH);
		
		RightCommand command = new RightCommand(toyRobot);
		command.execute();
		
		assertEquals(Direction.WEST, toyRobot.getFacing());
	}
	
	@Test
	public void execute_with_correct_right_west() {
		ToyRobot toyRobot = new ToyRobot();
		toyRobot.setPosition(new Position(2, 2));
		toyRobot.setFacing(Direction.WEST);
		
		RightCommand command = new RightCommand(toyRobot);
		command.execute();
		
		assertEquals(Direction.NORTH, toyRobot.getFacing());
	}

	
	@Test(expected = ToyRobotException.class)
	public void execute_with_incomplete_parameter() {
		
		RightCommand command = new RightCommand(null);
		command.execute();
	}
	
	@Test(expected = ToyRobotException.class)
	public void execute_with_toyrobot_not_placed() {
		ToyRobot toyRobot = new ToyRobot();
		
		RightCommand command = new RightCommand(toyRobot);
		command.execute();
	}
	
	
}
