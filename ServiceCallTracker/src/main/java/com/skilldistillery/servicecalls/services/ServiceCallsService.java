package com.skilldistillery.servicecalls.services;

import java.util.List;

import com.skilldistillery.servicecalls.entities.ServiceCall;

public interface ServiceCallsService {

	List<ServiceCall> getAllCustomers();
	
	ServiceCall getCustomerById();
	
	ServiceCall createNewCustomer();
}
