package com.project2.imfd.services;

import org.hibernate.hql.internal.ast.tree.BooleanLiteralNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project2.imfd.exceptions.CustomerNotFound;
import com.project2.imfd.exceptions.ProductNotFound;
import com.project2.imfd.model.Customer;
import com.project2.imfd.model.Item;
import com.project2.imfd.repo.CustomerRepository;

@Service
public class CustomerService {
	
	
	private final CustomerRepository cr;
	
	@Autowired
	public CustomerService(CustomerRepository cr) {
		super();
		this.cr = cr;
	}

	
	public boolean login(String uname, String pass) {
		boolean auth=false;
		Customer c = cr.findByusername(uname).orElseThrow(()-> new CustomerNotFound("Customer username: "+uname+" was not found"));
		String actPassword = c.getPassword();
		if(actPassword.equals(pass)) {
			auth = true;
		} else {
			System.out.println("Password incorrect");
		}
		return auth;
		
	}
	
	public Customer getCustomerByUsername(String uname){
		return cr.findByusername(uname).orElseThrow(() -> new ProductNotFound("This product is not available!"));
	}
}
