package com.lj.toyrobot.util;

public class Logger {
	
	public static void logInfo(String message, Object...args) {
		logMessage("Info: " + message, args);
	}
	
	public static void logError(String message, Object...args) {
		logMessage("Error: " + message, args);
	}
	
	public static void logMessage(String message, Object...args) {
		System.out.println(String.format(message, args));
	}
}
