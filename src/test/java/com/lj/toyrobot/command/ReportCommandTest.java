package com.lj.toyrobot.command;

import org.junit.Test;

import com.lj.toyrobot.command.ReportCommand;
import com.lj.toyrobot.exception.ToyRobotException;
import com.lj.toyrobot.model.Direction;
import com.lj.toyrobot.model.Position;
import com.lj.toyrobot.model.ToyRobot;


public class ReportCommandTest {
	
	@Test
	public void execute_with_correct_values() {
		ToyRobot toyRobot = new ToyRobot();
		toyRobot.setPosition(new Position(2, 2));
		toyRobot.setFacing(Direction.NORTH);
		
		ReportCommand command = new ReportCommand(toyRobot);
		command.execute();
		
		//TODO: Check system out
	}

	
	@Test(expected = ToyRobotException.class)
	public void execute_with_incomplete_parameter() {
		
		ReportCommand command = new ReportCommand(null);
		command.execute();
	}
	
	@Test(expected = ToyRobotException.class)
	public void execute_with_toyrobot_not_placed() {
		ToyRobot toyRobot = new ToyRobot();
		
		ReportCommand command = new ReportCommand(toyRobot);
		command.execute();
	}
	
	
}
