package com.project2.imfd.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project2.imfd.model.Cart;
import com.project2.imfd.repo.CartRepository;
import com.project2.imfd.services.CartService;
import com.project2.imfd.services.CustomerService;
import com.project2.imfd.services.ItemService;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@Getter
@Setter
@ToString
@RequestMapping("/cart")
public class CartController {

	private final CartService cart;
	private final CartRepository c;
	private final CustomerService cust;
	private final ItemService item;
	public CartController(CartService cart, CustomerService cust, ItemService item, CartRepository c) {
		super();
		this.cart = cart;
		this.cust = cust;
		this.item = item;
		this.c = c;
	}
	
	@GetMapping
	public List<Cart> showCart(int cust){
		
		return c.findAllByCustomer(cust);
	}
	
	
	@PostMapping("/add")
	public ResponseEntity<Cart> addCart(@RequestBody Cart newCart){
		Cart temp = cart.addToCart(newCart); 
		return new ResponseEntity<>(temp,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/increase")
	public ResponseEntity<?> increaseQ(@RequestParam int cust,@RequestParam int item) {
		cart.increaseQ(cust, item);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/decrease")
	public ResponseEntity<?> decreaseQ(@RequestParam int cust,@RequestParam int item) {
		cart.decreaseQ(cust, item);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> removeFromCart(@RequestParam int cust, @RequestParam int item){
			cart.removeFromCart(cust, item);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	
	
	
}
