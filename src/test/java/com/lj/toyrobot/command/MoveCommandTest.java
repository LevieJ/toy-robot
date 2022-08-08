package com.lj.toyrobot.command;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.lj.toyrobot.AppConstant;
import com.lj.toyrobot.command.MoveCommand;
import com.lj.toyrobot.exception.ToyRobotException;
import com.lj.toyrobot.model.Direction;
import com.lj.toyrobot.model.Position;
import com.lj.toyrobot.model.Table;
import com.lj.toyrobot.model.ToyRobot;


public class MoveCommandTest {
	
	private Table table;
	
	@Before
	public void setup() {
		table = new Table(5,5);
	}

	@Test
	public void execute_with_correct_move_north() {
		ToyRobot toyRobot = new ToyRobot();
		toyRobot.setPosition(new Position(2, 2));
		toyRobot.setFacing(Direction.NORTH);
		
		MoveCommand command = new MoveCommand(toyRobot, table, AppConstant.MOVE_DEFAULT_UNIT);
		command.execute();
		
		assertEquals(2, toyRobot.getPosition().getPosX());
		assertEquals(3, toyRobot.getPosition().getPosY());
	}
	
	@Test
	public void execute_with_correct_move_east() {
		ToyRobot toyRobot = new ToyRobot();
		toyRobot.setPosition(new Position(2, 2));
		toyRobot.setFacing(Direction.EAST);
		
		MoveCommand command = new MoveCommand(toyRobot, table, AppConstant.MOVE_DEFAULT_UNIT);
		command.execute();
		
		assertEquals(3, toyRobot.getPosition().getPosX());
		assertEquals(2, toyRobot.getPosition().getPosY());
	}
	
	@Test
	public void execute_with_correct_move_south() {
		ToyRobot toyRobot = new ToyRobot();
		toyRobot.setPosition(new Position(2, 2));
		toyRobot.setFacing(Direction.SOUTH);
		
		MoveCommand command = new MoveCommand(toyRobot, table, AppConstant.MOVE_DEFAULT_UNIT);
		command.execute();
		
		assertEquals(2, toyRobot.getPosition().getPosX());
		assertEquals(1, toyRobot.getPosition().getPosY());
	}
	
	@Test
	public void execute_with_correct_move_west() {
		ToyRobot toyRobot = new ToyRobot();
		toyRobot.setPosition(new Position(2, 2));
		toyRobot.setFacing(Direction.WEST);
		
		MoveCommand command = new MoveCommand(toyRobot, table, AppConstant.MOVE_DEFAULT_UNIT);
		command.execute();
		
		assertEquals(1, toyRobot.getPosition().getPosX());
		assertEquals(2, toyRobot.getPosition().getPosY());
	}

	
	@Test(expected = ToyRobotException.class)
	public void execute_with_incomplete_parameter() {
		ToyRobot toyRobot = new ToyRobot();
		
		MoveCommand command = new MoveCommand(toyRobot, null, 0);
		command.execute();
	}
	
	@Test(expected = ToyRobotException.class)
	public void execute_with_toyrobot_not_placed() {
		ToyRobot toyRobot = new ToyRobot();
		
		MoveCommand command = new MoveCommand(toyRobot, table, AppConstant.MOVE_DEFAULT_UNIT);
		command.execute();
	}
	
	@Test(expected = ToyRobotException.class)
	public void execute_with_move_lessthan_min_x() {
		ToyRobot toyRobot = new ToyRobot();
		toyRobot.setPosition(new Position(0, 0));
		toyRobot.setFacing(Direction.WEST);
		
		MoveCommand command = new MoveCommand(toyRobot, table, AppConstant.MOVE_DEFAULT_UNIT);
		command.execute();
	}
	
	@Test(expected = ToyRobotException.class)
	public void execute_with_move_lessthan_max_x() {
		ToyRobot toyRobot = new ToyRobot();
		toyRobot.setPosition(new Position(4, 4));
		toyRobot.setFacing(Direction.EAST);
		
		MoveCommand command = new MoveCommand(toyRobot, table, AppConstant.MOVE_DEFAULT_UNIT);
		command.execute();
	}
	
	@Test(expected = ToyRobotException.class)
	public void execute_with_move_lessthan_min_y() {
		ToyRobot toyRobot = new ToyRobot();
		toyRobot.setPosition(new Position(0, 0));
		toyRobot.setFacing(Direction.SOUTH);
		
		MoveCommand command = new MoveCommand(toyRobot, table, AppConstant.MOVE_DEFAULT_UNIT);
		command.execute();
	}
	
	@Test(expected = ToyRobotException.class)
	public void execute_with_move_lessthan_max_y() {
		ToyRobot toyRobot = new ToyRobot();
		toyRobot.setPosition(new Position(4, 4));
		toyRobot.setFacing(Direction.NORTH);
		
		MoveCommand command = new MoveCommand(toyRobot, table, AppConstant.MOVE_DEFAULT_UNIT);
		command.execute();
	}
	
}
