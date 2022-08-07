package com.project2.imfd.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project2.imfd.model.ShoppingCart;
import com.project2.imfd.repo.CartRepository;

@RestController
public class ShoppingCartController {

	@Autowired
	private CartRepository cartRepository;

	@PostMapping("/cart")
	private void addCart (@RequestBody ShoppingCart shopcart) {
		//open new cart table to hold items -- Open with add of item??
	cartRepository.save(shopcart);
	}
	
	@PutMapping("/cart/update")
	public ResponseEntity<ShoppingCart> updateCart(@RequestBody ShoppingCart productQunaity){
		return null;
	
	}
	
	@DeleteMapping("/cart/{cartId}")
	public void deleteCart(@PathVariable Integer cartId){
	// if clear cart 
		cartRepository.deleteById(cartId);
	}
	
	
	@DeleteMapping("/cart/{productId}")
	public void deleteProduct(@PathVariable int productQuanity){
	// if productQuanity = 0 delete item 
	//	cartRepository.deleteInBatch();
	}
	
	@GetMapping("/cart")
	public List <ShoppingCart> getPrintCart(){
		//Show all in the cart
		return cartRepository.findAll();
	}
	
	
	
}
