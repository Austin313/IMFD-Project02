package com.project2.imfd.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project2.imfd.model.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

	Optional<Customer> findByusername(String uname);

	//public Customer findByUsernameAndPassword(String username, String password);
	
	

}
