package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Customer;
import com.example.demo.domain.DietPlan;
import com.example.demo.exception.NutritionPlanException;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.DietPlanRepository;


@Service
public class DietPlanService {
	@Autowired
	private DietPlanRepository dietPlanRepository;
	@Autowired
	private CustomerRepository customerRepository;
	public DietPlan saveDietPlan(DietPlan dietPlan) {
		try {
			Customer customer=new Customer();
			if(customer.getCustomerIdentifier()!=null) {
			dietPlan=dietPlanRepository.findByCustomerIdentifier(customer.getCustomerIdentifier());
			dietPlan.setCustomerIdentifier(dietPlan.getCustomerIdentifier().toUpperCase());
			customer.setDietPlan(dietPlan);
			dietPlan.setCustomer(customer);
			}
			return dietPlanRepository.save(dietPlan);	
		}
		catch(Exception e) {
			throw new NutritionPlanException("This Diet-Plan: "+dietPlan.getId()+" already exists");
		}
		}
public DietPlan getDietPlanById(String customerIdentifier) {
	DietPlan diet= dietPlanRepository.findByCustomerIdentifier(customerIdentifier);
	if(diet==null) {
		throw new NutritionPlanException("Id: "+customerIdentifier+" not exists");
	}
	return diet;
}
public Iterable<DietPlan>getAllDietDetails(){
	return dietPlanRepository.findAll();
}
/*
public void deleteDietPlan(String customerIdentifier) {
	DietPlan diet= dietPlanRepository.findByCustomerIdentifier(customerIdentifier);
	if(diet==null) {
		throw new DietPlanException("Id: "+customerIdentifier+" not exists");
	}
	       dietPlanRepository.delete(diet);
}*/

}
