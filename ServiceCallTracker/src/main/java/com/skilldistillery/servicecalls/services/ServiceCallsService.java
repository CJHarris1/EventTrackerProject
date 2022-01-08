package com.skilldistillery.servicecalls.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.skilldistillery.servicecalls.entities.ServiceCall;

public interface ServiceCallsService {

	List<ServiceCall> getAllServiceCalls();
	
	List<ServiceCall> getServiceCallByDateScheduled(LocalDate date);
	
	List<ServiceCall> getServiceCallByDateCalled(LocalDate date);
	
	ServiceCall createNewServiceCall(int scId, ServiceCall sc);
	
	ServiceCall updateServiceCall(int scId, ServiceCall sc);
	
	boolean deleteServiceCall(int scId);
	
	ServiceCall getServiceCallByDateAndTime(LocalDate date, LocalTime time);
	
	List<ServiceCall> getServiceCallByCustomerId(int custId);
	
	List<ServiceCall> getServiceCallByAddressId(int addrId);
}
