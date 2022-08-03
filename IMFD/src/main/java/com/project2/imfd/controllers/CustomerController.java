package com.project2.imfd.controllers;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.project2.imfd.model.Customer;
import com.project2.imfd.repo.CustomerRepository;
import com.project2.imfd.services.CustomerService;

@RestController
public class CustomerController {

	private CustomerRepository cr;
	private CustomerService cs;
	
	@Autowired
	public CustomerController(CustomerRepository cr, CustomerService cs) {
		super();
		this.cr = cr;
		this.cs = cs;
	}
	
	@PostMapping("/customer")
	public void addCustomer(@RequestBody Customer customer) {
		cr.save(customer);
	}
	
	

	@PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestParam String uname, @RequestParam String pass) {
        boolean login = cs.login(uname, pass);
        return new ResponseEntity<>(login,HttpStatus.OK);
        
    }
	
	//to fetch data for customer profile using customer username
	@GetMapping("/profile/{uname}")
	public Customer getCostomerByUsername(@PathVariable String uname){
	Customer customer= cs.getCustomerByUsername(uname);
	return customer;
	}
	
}
