package com.mob41.hkoweather.thread;

import com.mob41.hkoweather.api.WeatherManager;

public class WeatherFetchInterval implements Runnable {

	private boolean running;
	private Thread thread;
	private WeatherManager man;
	private int interval;
	
	public WeatherFetchInterval(Thread thread, WeatherManager man, int ms){
		this.thread = thread;
		this.man = man;
		this.interval = ms;
	}
	
	public void run() {
		start();
	}
	
	public void start(){
		if (!running){
			running = true;
			try {
				man.fetchWeatherReport();
				thread.wait(interval);
			} catch (Exception e){
				thread.interrupt();
			}
		}
	}
	
	public void stop(){
		if (running){
			running = false;
			thread.interrupt();
		}
	}

}
