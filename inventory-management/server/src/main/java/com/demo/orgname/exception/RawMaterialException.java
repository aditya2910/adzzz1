package com.demo.orgname.exception;

public class RawMaterialException extends Exception {
	
	private String errorMessage;
	private Throwable exception; 
	
	public RawMaterialException() {
		super();
	}

	public RawMaterialException(String errorMessage, Throwable e) {
		super(errorMessage, e);
		this.errorMessage = errorMessage;
		this.exception = e;
	}
	
	public RawMaterialException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}
	
	public Throwable getException() {
		return exception;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
