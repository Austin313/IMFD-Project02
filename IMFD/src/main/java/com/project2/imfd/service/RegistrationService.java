package com.project2.imfd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project2.imfd.model.Customer;
import com.project2.imfd.repo.RegistrationRepository;

@Service
public class RegistrationService {
	
	@Autowired
	private RegistrationRepository repo;
	
	public Customer saveCustomer (Customer customer) {
		
		return repo.save(customer);
		
	}
	
	public Customer fetchCustomerByUsername(String username) {
				
		return repo.findByUsername(username);
		
	}
	
}
