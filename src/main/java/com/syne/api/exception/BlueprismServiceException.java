package com.syne.api.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BlueprismServiceException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public BlueprismServiceException(String message) {
		super(message);
	}
	
	public BlueprismServiceException(String message, Throwable t) {
		super(message, t);
	}
}

