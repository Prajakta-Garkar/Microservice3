package com.example.demo;

public class ErrorDetails {

	private String message;
	private int status;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public ErrorDetails(String message, int status) {
		super();
		this.message = message;
		this.status = status;
	}
	
}
