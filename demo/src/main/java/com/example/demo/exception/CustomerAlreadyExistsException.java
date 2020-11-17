package com.example.demo.exception;

public class CustomerAlreadyExistsException extends RuntimeException {
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public CustomerAlreadyExistsException() {
		
	}

public CustomerAlreadyExistsException(String message) {
	super(message);
}
}
