package com.skilldistillery.servicecalls.services;

import java.util.List;

import com.skilldistillery.servicecalls.entities.Customer;

public interface ServiceCallsService {

	List<Customer> getAllCustomers();
	
	Customer getCustomerById();
	
	Customer createNewCustomer();
}
