package com.demo.orgname.exception;

public class RawMaterialTypeException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private String errorMessage;
	private Throwable exception;
	private int errorCode;
	
	public RawMaterialTypeException() {
		super();
	}

	public RawMaterialTypeException(String errorMessage, Throwable e, int errorCode) {
		super(errorMessage, e);
		this.errorMessage = errorMessage;
		this.exception = e;
		this.errorCode = errorCode;
	}
	
	public RawMaterialTypeException(String errorMessage, int errorCode) {
		super(errorMessage);
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public Throwable getException() {
		return exception;
	}

	public int getErrorCode() {
		return errorCode;
	}
	
	
}
