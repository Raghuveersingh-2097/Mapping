package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import com.example.demo.domain.Customer;
//import com.example.demo.domain.DietPlan;
import com.example.demo.service.CustomerService;
//import com.example.demo.service.DietPlanService;
import com.example.demo.service.ValidationService;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

@Autowired	
private CustomerService customerService;
@Autowired
private ValidationService validationService;


	@PostMapping("")
	public ResponseEntity<?> createNewCustomer(@Valid @RequestBody Customer customer,BindingResult result) {
	ResponseEntity<?> errorMsg=	validationService.validationError(result);
	if(errorMsg!=null)return errorMsg;
		Customer cust=customerService.save(customer);
		return new ResponseEntity<Customer>(cust,HttpStatus.OK);
	}
	
	@GetMapping("/{customerIdentifier}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable String customerIdentifier){
		Customer cust=customerService.findCustomerById(customerIdentifier);
		return new ResponseEntity<Customer>(cust,HttpStatus.OK);
	}
	@GetMapping("/all")
	public Iterable<Customer> getAllProjects(){
		return customerService.getAllCustomerDetails();
	}
	@DeleteMapping("/{customerIdentifier}")
	public ResponseEntity<?> DeleteCustomerById(@PathVariable String customerIdentifier){
		customerService.deleteCustomerById(customerIdentifier);
		return new ResponseEntity<String>("Customer with ID "+customerIdentifier+" was deleted",HttpStatus.OK);
	}
}
