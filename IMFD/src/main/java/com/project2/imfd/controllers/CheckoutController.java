package com.project2.imfd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project2.imfd.model.OrderDetail;
import com.project2.imfd.repo.OrderDetailRepository;

@RestController
public class CheckoutController {
	

	public OrderDetailRepository or;
	
	
	@Autowired
	public CheckoutController(OrderDetailRepository or) {
		super();
		this.or = or;
	}



	@PostMapping("/checkout")
	public void checkout(@RequestBody OrderDetail orderDetail ) {
		or.save(orderDetail);
	}
	

}
