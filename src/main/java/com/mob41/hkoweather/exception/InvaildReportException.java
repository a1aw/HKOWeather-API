package com.mob41.hkoweather.exception;

/***
 * The weather report fetched was invalid.
 * @author mob41
 *
 */
public class InvaildReportException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvaildReportException(){
		super();
	}
	
	public InvaildReportException(String message){
		super(message);
	}
	
	public InvaildReportException(String message, Throwable cause){
		super(message, cause);
	}
	
	public InvaildReportException(Throwable cause){
		super(cause);
	}
}
