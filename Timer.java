package com.sorrer.utils;

public class Timer {
	private int countTo = 0;
	private boolean done = true;
	private long cur = 0;
	
	public Timer(int milliseconds){
		this.countTo = milliseconds;
	}
	
	/**
	 * Starts the timer
	 */
	public void start(){
		PrintLog.printSys("Starting timer for " + countTo + " milliseconds");
		done = false;
		Thread worker = new Worker();
		worker.start();
	}
	
	/**
	 * Is the timer done?
	 * @return boolean
	 */
	public boolean isDone(){
		return done;
	}
	
	/**
	 * How much elapsed time.
	 * @return Milliseconds
	 */
	public int getProgressTime(){
		return (int) (System.currentTimeMillis() - cur);
	}
	
	/**
	 * How far it elapsed.
	 * @return percentage
	 */
	public float getProgress(){
		return ((float) getProgressTime()) / ((float) countTo);
	}
	
	/**
	 * Sets the length of time the timer should count to
	 */
	public void setTimer(int milliseconds){
		this.countTo = milliseconds;
	}
	
	private class Worker extends Thread{
		
		@Override
		public void run(){
			cur = System.currentTimeMillis();
			while(System.currentTimeMillis() < cur+countTo); //Stalling
			done = true;
		}
	}
}
