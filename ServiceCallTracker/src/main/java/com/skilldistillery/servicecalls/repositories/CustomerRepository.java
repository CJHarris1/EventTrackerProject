package com.skilldistillery.servicecalls.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.servicecalls.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
