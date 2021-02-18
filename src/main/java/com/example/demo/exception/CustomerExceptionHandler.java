package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomerExceptionHandler extends ResponseEntityExceptionHandler{
/***-----------------------------------Customer-Exception-Part---------------------------*/	
@ExceptionHandler
public ResponseEntity<Object>handleCustomerNameException(CustomerContactException ex,WebRequest request){
	CustomerContactExceptionResponse customerExceptionResponse=new CustomerContactExceptionResponse(ex.getMessage());
	return new ResponseEntity<Object>(customerExceptionResponse,HttpStatus.BAD_REQUEST);
}
/**---------------------------------Nutrition-Exception-Part------------------------------**/
@ExceptionHandler
public ResponseEntity<Object> handleDietPlanException(NutritionPlanException ex, WebRequest request){
	NutritionPlanExceptionResponse dietPlanExceptionResponse =  new NutritionPlanExceptionResponse(ex.getMessage());
	return new ResponseEntity<Object>(dietPlanExceptionResponse,HttpStatus.BAD_REQUEST);
}	

@ExceptionHandler
public ResponseEntity<Object> handlePaymentIdNotFoundException(PaymentIdNotFoundException ex, WebRequest request){
	PaymentIdNotFoundExceptionResponse paymentIdNotFoundExceptionResponse =  new PaymentIdNotFoundExceptionResponse(ex.getMessage());
	return new ResponseEntity<Object>(paymentIdNotFoundExceptionResponse,HttpStatus.BAD_REQUEST);
}	
/**
**/
}
