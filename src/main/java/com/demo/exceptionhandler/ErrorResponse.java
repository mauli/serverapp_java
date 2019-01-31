package com.demo.exceptionhandler;

public class ErrorResponse {
	
	private String statusCode;
	private String description;
	
	public ErrorResponse(String statusCode, String description) {
		super();
		this.statusCode = statusCode;
		this.description = description;
	}
	public String getStatus() {
		return statusCode;
	}
	public void setStatus(String status) {
		this.statusCode = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
