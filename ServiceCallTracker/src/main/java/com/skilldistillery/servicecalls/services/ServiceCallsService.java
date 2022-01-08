package com.skilldistillery.servicecalls.services;

import java.time.LocalDate;
import java.util.List;

import com.skilldistillery.servicecalls.entities.Address;
import com.skilldistillery.servicecalls.entities.Customer;
import com.skilldistillery.servicecalls.entities.ServiceCall;

public interface ServiceCallsService {

	List<ServiceCall> getAllServiceCalls();
	
	List<ServiceCall> getServiceCallsByDateScheduled(LocalDate date);
	
	List<ServiceCall> getServiceCallsByDateCalled(LocalDate date);
	
	ServiceCall createNewServiceCall(int scId, ServiceCall sc);
	
	ServiceCall updateServiceCall(int scId, ServiceCall sc);
	
	ServiceCall deleteServiceCall(int scId);
	
	ServiceCall getServiceCallByDateAndTime(LocalDate date, int time);
	
	List<ServiceCall> getServiceCallsByCustomer(Customer customer);
	
	List<ServiceCall> getServiceCallsByAddress(Address addresss);
}
