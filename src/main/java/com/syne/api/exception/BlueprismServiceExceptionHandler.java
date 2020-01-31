package com.syne.api.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.syne.api.model.response.ErrorMessage;

@ControllerAdvice
public class BlueprismServiceExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value = BlueprismServiceException.class)
	public ResponseEntity<Object> handleEmpNotFoundException(Exception e, WebRequest req) {
		String errorMsgDesc = e.getLocalizedMessage();
		if(errorMsgDesc == null) errorMsgDesc = e.toString();
		ErrorMessage errorMessage = new ErrorMessage(new Date(), errorMsgDesc);
		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
