package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.cg.ppmtoolapi.domain.ProjectTask;
import com.example.demo.domain.Customer;
import com.example.demo.domain.Payment;
import com.example.demo.exception.CustomerContactException;
import com.example.demo.exception.PaymentIdNotFoundException;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.PaymentRepository;

@Service
public class PaymentService {
	
@Autowired
private CustomerRepository customerRepository;
@Autowired
private PaymentRepository paymentRepository;
Integer PTSsequence=0;
String paymentTransactionId;
public Payment addPayment(String paymentIdentifier, Payment payment) {
	try {	
	Customer customer=customerRepository.findByPaymentIdentifier(paymentIdentifier);
	System.out.println(payment.getId());
	if(payment.getId()==null){
    paymentTransactionId=payment.getTransactionId();
	PTSsequence++;
	paymentTransactionId=Integer.toString(PTSsequence)+"-PAY";
	payment.setTransactionId(paymentTransactionId);
	customer.setPaymentIdentifier(paymentIdentifier);
	payment.setPaymentIdentifier(paymentIdentifier);
	payment.setCustomer(customer);
	}
	if(payment.getId()!=null) {
		payment.setTransactionId(paymentTransactionId);
		customer.setPaymentIdentifier(paymentIdentifier);
		payment.setPaymentIdentifier(paymentIdentifier);
		payment.setCustomer(customer);
	 }
	return paymentRepository.save(payment);
	}
	catch (Exception e) {
	throw new PaymentIdNotFoundException("Specified Payment is not there, Please check your input");
	}
}
public Payment findPaymentByTransactionId(String transactionId) {
	Payment pay=paymentRepository.findByTransactionId(transactionId);
	if(pay==null) {
		throw new PaymentIdNotFoundException("Pay Id:"+transactionId+" not found");
	}
	return pay;
}

public void deletePaymentByTransactionId(Long id) {
	 paymentRepository.deleteById(1L);
	
}
}
