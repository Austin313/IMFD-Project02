package com.project2.imfd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project2.imfd.model.Customer;
import com.project2.imfd.service.RegistrationService;

@RestController
public class RegistrationController {

		@Autowired
		private RegistrationService service;
		
		@PostMapping("/register")
		public Customer registerCustomer (@RequestBody Customer customer) throws Exception {
			String tempusername= customer.getUsername();
			if (tempusername !=null && !"".equals(tempusername)) {
				Customer customercheck=service.fetchCustomerByUsername(tempusername);
				if (customercheck != null) {
					throw new Exception ("User already exit");
				}
			}
			Customer customerObj =null;
			customerObj = service.saveCustomer(customer);
			return customerObj;
		}
}
