package com.skilldistillery.servicecalls.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.servicecalls.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	List<Customer> findByFirstName(String name);
	
	List<Customer> findByLastName(String name);
	
	Customer findByPhoneNumber(String phoneNumber);
	
	List<Customer> findByFirstNameAndLastName(String fName, String lName);
}
