package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Customer;
import com.example.demo.domain.DietPlan;
import com.example.demo.domain.NutritionPlan;
import com.example.demo.exception.CustomerContactException;
import com.example.demo.presentation.DietInsertion;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.DietPlanRepository;

@Service
public class CustomerService {

@Autowired
private CustomerRepository customerRepository;
@Autowired
private DietPlanRepository dietPlanRepository;

public Customer save(Customer customer) {
	try {
		customer.setCustomerIdentifier(customer.getCustomerIdentifier().toUpperCase());
	  if(customer.getId()==null) {
		DietPlan dietPlan=new DietPlan();
		customer.setDietPlan(dietPlan);
		dietPlan.setCustomer(customer);
		dietPlan.setCustomerIdentifier(customer.getCustomerIdentifier().toUpperCase());
}
	 if(customer.getId()!=null) {
		customer.setDietPlan(dietPlanRepository.findByCustomerIdentifier(customer.getCustomerIdentifier().toUpperCase()));
			
	 }
	 return customerRepository.save(customer);
	}
	catch(Exception e) {
		throw new CustomerContactException("Contact: "+customer.getContact()+" already exists");
	}
	}
public Customer findCustomerById(String customerIdentifier) {
	Customer customer=customerRepository.findByCustomerIdentifier(customerIdentifier);
	if(customer==null) {
		throw new CustomerContactException("Id: "+customerIdentifier+" doesn't exists");
	}
	return customer;
}
public Iterable<Customer>getAllCustomerDetails(){
	return customerRepository.findAll();
}
public void deleteCustomerById(String customerIdentifier) {
	Customer customer=customerRepository.findByCustomerIdentifier(customerIdentifier);
	if(customer==null) {
		throw new CustomerContactException("Id: "+customerIdentifier+" doesn't exists");
	}
	customerRepository.delete(customer);
}
}
/*try {
		customer.setIdentifier(customer.getIdentifier().toUpperCase());
		catch(Exception e) {
		throw new CustomerNameException("Name: "+customer.getIdentifier().toUpperCase()+" already there");
	}*/