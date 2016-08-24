package com.sorrer.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class PrintLog {
	
	/**
	 * Prints using "[System]" tag with current time of print.
	 * @param msg Message
	 */
	public static void printSys(String msg){
		System.out.println("[System] [" + getTimeStamp() + "] " + msg);
	}
	
	/**
	 * Prints using "[Game]" tag with current time of print.
	 * @param msg
	 */
	public static void printGame(String msg){
		System.out.println("[Game] [" + getTimeStamp() + "] " + msg);
	}
	
	/**
	 * @return "yyyy/MM/dd HH:mm:ss"
	 */
	private static String getTimeStamp(){
		return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
	}
}
