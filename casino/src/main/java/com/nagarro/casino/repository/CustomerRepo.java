package com.nagarro.casino.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.casino.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long>{

}
