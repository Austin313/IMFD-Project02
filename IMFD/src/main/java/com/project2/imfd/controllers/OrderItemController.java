package com.project2.imfd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.project2.imfd.repo.OrderItemRepository;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class OrderItemController {
	private OrderItemRepository oir;

	@Autowired
	public void setOir(OrderItemRepository oir) {
		this.oir = oir;
	}
	
	
}
