package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(HotelNotFoundException.class)
	public ResponseEntity<ErrorDetails> hotelNotFoundException(HotelNotFoundException ex){
		ErrorDetails errorDetail= new ErrorDetails(ex.getMessage(),0);
		return new ResponseEntity<ErrorDetails>(errorDetail,HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler(Exception.class)
	ResponseEntity<?> globalExceptionHandler(Exception ex){
		ErrorDetails errorDetail= new ErrorDetails(ex.getMessage(),0);
		return new ResponseEntity<>(errorDetail,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
