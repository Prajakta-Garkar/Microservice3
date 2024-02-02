package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class HotelNotFoundException extends RuntimeException{

	public HotelNotFoundException() {
		super("Hoel not found...");
	}
	public HotelNotFoundException(String message) {
		super(message);
	}
}
