package com.nagarro.casino.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.casino.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{

	List<Customer> findByName(String name);
	
	List<Customer> findByContact(long contact);
	
	List<Customer> findByEmail(String email);
}
