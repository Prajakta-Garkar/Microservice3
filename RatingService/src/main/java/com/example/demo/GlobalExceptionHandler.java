package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(RatingNotFoundException.class)
	public ResponseEntity<ErrorDetail> ratingNotFoundException(RatingNotFoundException ex){
		ErrorDetail errorDetail= new ErrorDetail(ex.getMessage(),0);
		return new ResponseEntity<ErrorDetail>(errorDetail,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globalExceptionHandler(Exception ex){
		ErrorDetail errorDetail=new ErrorDetail(ex.getMessage(),0);
		return new ResponseEntity<>(errorDetail, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
