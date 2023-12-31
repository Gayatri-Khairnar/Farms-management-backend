package com.agro.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class GenricProcessException extends Exception {
	
	private String statusCode;

	private Object data;

	private boolean success;
	
	public GenricProcessException() {
		super();
	}
	
	public GenricProcessException(String message, String statusCode) {
		super(message);
		this.statusCode = statusCode;
	}

	public GenricProcessException( String message, String statusCode,Object data, boolean success) {
		super(message);
		this.statusCode = statusCode;
		this.data = data;
		this.success = success;
	}

	public String getStatusCode() {
		return this.statusCode;
	}

}