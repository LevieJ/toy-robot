package com.lj.toyrobot.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.lj.toyrobot.model.Direction;
import com.lj.toyrobot.model.Position;
import com.lj.toyrobot.model.ToyRobot;

public class ToyRobotTest {
	
	@Test
	public void isplaced_with_correct_values() {
		ToyRobot toyRobot = new ToyRobot();
		toyRobot.setPosition(new Position(2,3));
		toyRobot.setFacing(Direction.NORTH);
		
		assertEquals(true, toyRobot.isPlaced());
	}
	
	@Test
	public void isplaced_with_no_position() {
		ToyRobot toyRobot = new ToyRobot();
		toyRobot.setPosition(null);
		toyRobot.setFacing(Direction.NORTH);
		
		assertEquals(false, toyRobot.isPlaced());
	}
	
	@Test
	public void isplaced_with_no_direction() {
		ToyRobot toyRobot = new ToyRobot();
		toyRobot.setPosition(new Position(2,3));
		toyRobot.setFacing(null);
		
		assertEquals(false, toyRobot.isPlaced());
	}
	
}
