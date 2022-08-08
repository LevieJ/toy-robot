package com.lj.toyrobot;

public class AppConstant {
	
	public static final int TABLE_WIDTH = 5;
	public static final int TABLE_HEIGHT = 5;
	
	public static final int MOVE_DEFAULT_UNIT = 1;
	
	public static final String REPORT_COMMAND_OUTPUT = "Output: %d,%d,%s";
	
	// Info messages
	public static final String INFO_MOVING = "Moving to (%d, %d)";
	public static final String INFO_TURNING = "Turning Toy Robot to %s";
	public static final String INFO_PLACING = "Placing Toy Robot to (%d, %d), facing %s.";
	
	// Error Messages
	public static final String ERROR_INVALID_INPUT = "Invalid Input.";
	public static final String ERROR_INCOMPLETE_PARAMTER = "Incomplement Parameter";
	public static final String ERROR_UNSUPPORTED_COMMAND = "Unsupported command.";
	public static final String ERROR_NOT_PLACED = "Toy Robot: I'm not placed yet.";
	public static final String ERROR_WRONG_POSITION_MOVE = "Toy Robot: Oops! I can't move, I'll fall.";
	public static final String ERROR_WRONG_POSITION_PLACE = "Toy Robot: I can't go there, it's out of bounds.";


}
