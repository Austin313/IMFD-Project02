package com.project2.imfd.controllers;



import java.net.http.HttpRequest;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session.Cookie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins="http://localhost:4200")

public class CustomerController {

	private CustomerRepository cr;
	private CustomerService cs;
	public HttpServletRequest req;
	public HttpSession session;
	public Cookie cookie;
	public static String username;

	
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
	
	

	@GetMapping("/login")
    public ResponseEntity<Customer> login(@RequestParam String uname, @RequestParam String pass) {
		Customer customer=null;
		if(cs.login(uname, pass)) {
			customer = cs.getCustomerByUsername(uname);
			username = uname;
			
		}
        return new ResponseEntity<>(customer,HttpStatus.OK);
        
    }
	
	//to fetch data for customer profile using customer username
	@GetMapping("/profile")
	public ResponseEntity<Customer> getCustomerByUsername(){
	Customer customer= cs.getCustomerByUsername(username);
	return new ResponseEntity<>(customer,HttpStatus.OK);
	}
	
}
