package com.example.demo.exception;

public class PaymentIdNotFoundExceptionResponse {
	
	private String projectNotFound;

	public PaymentIdNotFoundExceptionResponse(String projectNotFound) {
		super();
		this.projectNotFound = projectNotFound;
	}

	public String getProjectNotFound() {
		return projectNotFound;
	}

	public void setProjectNotFound(String projectNotFound) {
		this.projectNotFound = projectNotFound;
	}
	
	

}
