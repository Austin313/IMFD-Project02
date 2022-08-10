package com.project2.imfd.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project2.imfd.model.Cart;
import com.project2.imfd.model.Customer;

public interface CartRepository extends JpaRepository<Cart,Integer>{
	
	public Cart findByCustomerAndItemId(int cust, int item);

	public List<Cart> findAllByCustomer(int cust);

}
