package com.example.demo.exception;

public class CustomerContactExceptionResponse {

private String customerName;

public CustomerContactExceptionResponse(String customerName) {
	super();
	this.customerName=customerName;
}
public String getCustomerName() {
	return customerName;
}
public void setCustomerName(String customerName) {
	this.customerName=customerName;
}
}
