package com.finzly.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Error> myExceptionHandler(ResourceNotFoundException rne, WebRequest wr){
		
		Error er = new Error(rne.getMessage(),wr.getDescription(false));
		
		return new ResponseEntity<Error>(er, HttpStatus.BAD_REQUEST);
	}
	
	
	public ResponseEntity<Error> myExcHandler(Exception e, WebRequest wr){
		Error err=new Error(e.getMessage(), wr.getDescription(false));
		
		return new ResponseEntity<Error>(err, HttpStatus.BAD_REQUEST);
	}

}
