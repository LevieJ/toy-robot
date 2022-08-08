package com.lj.toyrobot.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.lj.toyrobot.command.PlaceCommand;
import com.lj.toyrobot.exception.ToyRobotException;
import com.lj.toyrobot.model.Direction;
import com.lj.toyrobot.model.Position;
import com.lj.toyrobot.model.Table;
import com.lj.toyrobot.model.ToyRobot;

public class PlaceCommandTest {

	private Table table;

	@Before
	public void setup() {
		table = new Table(5, 5);
	}

	@Test
	public void execute_with_correct_values() {
		ToyRobot toyRobot = new ToyRobot();
		Position position = new Position(1, 1);
		Direction direction = Direction.NORTH;

		PlaceCommand command = new PlaceCommand(toyRobot, table, position, direction);
		command.execute();

		assertNotNull(toyRobot.getPosition());
		assertEquals(position.getPosX(), toyRobot.getPosition().getPosX());
		assertEquals(position.getPosY(), toyRobot.getPosition().getPosY());

		assertNotNull(toyRobot.getFacing());
		assertEquals(direction, toyRobot.getFacing());
	}

	@Test(expected = ToyRobotException.class)
	public void execute_with_incomplete_parameter() {
		ToyRobot toyRobot = new ToyRobot();

		PlaceCommand command = new PlaceCommand(toyRobot, table, null, null);
		command.execute();
	}

	@Test(expected = ToyRobotException.class)
	public void execute_with_position_x_lessthan_min() {
		ToyRobot toyRobot = new ToyRobot();
		Position position = new Position(-1, 1);
		Direction direction = Direction.NORTH;

		PlaceCommand command = new PlaceCommand(toyRobot, table, position, direction);
		command.execute();
	}

	@Test(expected = ToyRobotException.class)
	public void execute_with_position_x_greaterthan_max() {
		ToyRobot toyRobot = new ToyRobot();
		Position position = new Position(5, 1);
		Direction direction = Direction.NORTH;

		PlaceCommand command = new PlaceCommand(toyRobot, table, position, direction);
		command.execute();
	}

	@Test(expected = ToyRobotException.class)
	public void execute_with_position_y_lessthan_min() {
		ToyRobot toyRobot = new ToyRobot();
		Position position = new Position(1, -1);
		Direction direction = Direction.NORTH;

		PlaceCommand command = new PlaceCommand(toyRobot, table, position, direction);
		command.execute();
	}

	@Test(expected = ToyRobotException.class)
	public void execute_with_position_y_greaterthan_max() {
		ToyRobot toyRobot = new ToyRobot();
		Position position = new Position(1, 5);
		Direction direction = Direction.NORTH;

		PlaceCommand command = new PlaceCommand(toyRobot, table, position, direction);
		command.execute();
	}
}
