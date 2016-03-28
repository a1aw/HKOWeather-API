package com.mob41.hkoweather.exception;

/***
 * The station code specified by the user was invaild.
 * @author mob41
 *
 */
public class InvaildStationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvaildStationException(){
		super();
	}
	
	public InvaildStationException(String message){
		super(message);
	}
	
	public InvaildStationException(String message, Throwable cause){
		super(message, cause);
	}
	
	public InvaildStationException(Throwable cause){
		super(cause);
	}
}
