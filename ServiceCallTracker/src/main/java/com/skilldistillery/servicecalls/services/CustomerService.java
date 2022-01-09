package com.skilldistillery.servicecalls.services;

import java.util.List;

import com.skilldistillery.servicecalls.entities.Customer;

public interface CustomerService {
	
	List<Customer> getAllCustomers();
	
	Customer createNewCustomer(Customer cust);
	
	Customer updateCustomer(int custId, Customer cust);
	
	List<Customer> getCustomerByFirstName(String name);
	
	List<Customer> getCustomerLastName(String name);
	
	Customer getCustomerPhoneNumber(String phoneNumber);
	

}
