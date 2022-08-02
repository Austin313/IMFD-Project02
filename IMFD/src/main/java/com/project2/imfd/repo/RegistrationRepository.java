package com.project2.imfd.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project2.imfd.model.Customer;

public interface RegistrationRepository extends JpaRepository<Customer,Integer> {

	public Customer findByUsername(String username);

}
