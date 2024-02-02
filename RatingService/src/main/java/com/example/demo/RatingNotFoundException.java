package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class RatingNotFoundException extends RuntimeException {

	public RatingNotFoundException() {
		super("Rating not found...");
	}
	
	public RatingNotFoundException(String message) {
		super(message);
	}
}
