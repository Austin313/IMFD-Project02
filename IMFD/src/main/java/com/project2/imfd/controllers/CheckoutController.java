package com.project2.imfd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project2.imfd.model.OrderDetail;
import com.project2.imfd.repo.OrderDetailRepository;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class CheckoutController {
	

	public OrderDetailRepository or;
	
	
	@Autowired
	public CheckoutController(OrderDetailRepository or) {
		super();
		this.or = or;
	}



	@PostMapping("/checkout")
	public ResponseEntity<OrderDetail> checkout(@RequestBody OrderDetail orderDetail ) {
		OrderDetail order = or.save(orderDetail);
		return new ResponseEntity<>(order,HttpStatus.CREATED);
	}
	

}
