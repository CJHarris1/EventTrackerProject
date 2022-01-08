package com.skilldistillery.servicecalls.services;

import java.util.List;

import com.skilldistillery.servicecalls.entities.Address;
import com.skilldistillery.servicecalls.entities.Customer;

public interface CustomerService {
	
	List<Customer> getAllCustomers();
	
	Customer createNewCustomer(int custId, Customer cust);
	
	Customer updateCustomer(int custId, Customer cust);
	
	List<Customer> getCustomerByFirstName(String name);
	
	List<Customer> getCustomerLastName(String name);
	
	Customer getCustomerPhoneNumber(String phoneNumber);
	
	Customer getCustomerByAddress(Address address);

}
