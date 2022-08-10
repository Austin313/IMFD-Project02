package com.project2.imfd.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project2.imfd.exceptions.CustomerNotFound;
import com.project2.imfd.exceptions.ProductNotFound;
import com.project2.imfd.model.Cart;
import com.project2.imfd.model.Customer;
import com.project2.imfd.model.Item;
import com.project2.imfd.repo.CartRepository;
import com.project2.imfd.repo.CustomerRepository;
import com.project2.imfd.repo.ItemRepository;


@Service
public class CartService {

	private final CartRepository cr;
	private final CustomerRepository cusR;
	private final ItemRepository ir;

	@Autowired
	public CartService(CartRepository cr, CustomerRepository cusR, ItemRepository ir) {
		super();
		this.cr = cr;
		this.cusR = cusR;
		this.ir = ir;
	}
	
	public Cart addToCart(Cart cart) {
//		Customer c = cusR.findById(cart.getId().getCust_id()).orElseThrow(() -> new CustomerNotFound("Customer was not found"));
//		Item i = ir.findById(cart.getId().getItemNo()).orElseThrow(() -> new ProductNotFound("Item was not found"));
//		CartKey key = new CartKey(c.getCustomer_id(),i.getItemno());
//		Cart newCart = new Cart(key,c,i,cart.getQuantity());
		
		return cr.save(cart);
	}

	

	public List<Cart> showCart(){
		return cr.findAll();	
	}
	
	public Cart increaseQ(int cust, int item) {
		Cart cart = cr.findByCustomerAndItemId(cust,item);
		int current = cart.getQuantity();
		current++;
		cart.setQuantity(current);
		return cr.save(cart);
		
	}
	
	public Cart decreaseQ(int cust, int item) {
		Cart cart = cr.findByCustomerAndItemId(cust,item);
		int current = cart.getQuantity();
		current--;
		if(current <= 0) {
			cr.deleteById(cart.getCart_id());
		} else {
			cart.setQuantity(current);
			cr.save(cart);
		}
		
		return cart;
		
	}
	
	public void removeFromCart(int cust, int item) {
		Cart cart = cr.findByCustomerAndItemId(cust,item);		
		cr.deleteById(cart.getCart_id());
	}
}
