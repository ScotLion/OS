package com.alessandro.os.services.exception;

public class DataIntegrityViolationExeption extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public DataIntegrityViolationExeption(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DataIntegrityViolationExeption(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
}
