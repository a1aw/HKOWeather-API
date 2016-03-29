package com.mob41.hkoweather.thread;

import com.mob41.hkoweather.api.WeatherManager;

public class WeatherFetchInterval implements Runnable {

	private boolean running = false;
	private Thread thread;
	private WeatherManager man;
	private int interval;
	
	public WeatherFetchInterval(WeatherManager man, int ms){
		this.man = man;
		this.interval = ms;
	}
	
	public void run() {
		start();
	}
	
	public void start(){
		if (!running){
			this.thread = man.thread;
			running = true;
			while(running){
				try {
					man.fetchWeatherReport();
					synchronized(thread){
						thread.wait(interval);
					}
				} catch (Exception e){
					thread.interrupt();
					break;
				}
			}
			running = false;
		}
	}
	
	public void stop(){
		if (running){
			running = false;
			thread.interrupt();
		}
	}

}
