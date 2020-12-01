package com.pccw.prodspec.bff.exception;

public class CustomException extends RuntimeException 
{
	
	private static final long serialVersionUID = 1L;
	
	
	private final String details;

	public CustomException(String message, String details) {
	   super(message);
	    this.details = details;
	}	

	public String getDetails() {
		return details;
	}
  
}