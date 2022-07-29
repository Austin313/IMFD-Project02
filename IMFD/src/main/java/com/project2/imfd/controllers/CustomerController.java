package com.project2.imfd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project2.imfd.model.Customer;
import com.project2.imfd.repo.CustomerRepository;

@RestController
public class CustomerController {

	private CustomerRepository cr;
	
	@Autowired
	public void setCr(CustomerRepository cr) {
		this.cr = cr;
	}
	
	@PostMapping("/customer")
	public void addCustomer(@RequestBody Customer customer) {
		cr.save(customer);
	}
	
}
