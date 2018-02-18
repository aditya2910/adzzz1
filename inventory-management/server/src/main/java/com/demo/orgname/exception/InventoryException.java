package com.demo.orgname.exception;

public class InventoryException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private String errorMessage;
	private Throwable exception;
	private int errorCode;
	
	public InventoryException() {
		super();
	}

	public InventoryException(String errorMessage, Throwable e, int errorCode) {
		super(errorMessage, e);
		this.errorMessage = errorMessage;
		this.exception = e;
		this.errorCode = errorCode;
	}
	
	public InventoryException(String errorMessage, int errorCode) {
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
