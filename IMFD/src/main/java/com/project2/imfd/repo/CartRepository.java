package com.project2.imfd.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project2.imfd.model.Cart;
import com.project2.imfd.model.CartKey;
import com.project2.imfd.model.Customer;

public interface CartRepository extends JpaRepository<Cart,Integer>{
	
	

}
