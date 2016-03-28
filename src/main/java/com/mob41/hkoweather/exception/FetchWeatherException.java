package com.mob41.hkoweather.exception;

/***
 * Could not fetch the weather report from HKO successfully.
 * @author mob41
 *
 */
public class FetchWeatherException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FetchWeatherException(){
		super();
	}
	
	public FetchWeatherException(String message){
		super(message);
	}
	
	public FetchWeatherException(String message, Throwable cause){
		super(message, cause);
	}
	
	public FetchWeatherException(Throwable cause){
		super(cause);
	}
}
