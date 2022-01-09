package com.skilldistillery.servicecalls.services;

import java.time.LocalDate;
import java.util.List;

import com.skilldistillery.servicecalls.entities.ServiceCall;

public interface ServiceCallsService {

	List<ServiceCall> getAllServiceCalls();
	
	List<ServiceCall> getServiceCallsByDateScheduled(LocalDate date);
	
	List<ServiceCall> getServiceCallsByDateCalled(LocalDate date);
	
	ServiceCall createNewServiceCall(ServiceCall sc);
	
	ServiceCall updateServiceCall(int scId, ServiceCall sc);
	
	ServiceCall deleteServiceCall(int scId);
	
	List<ServiceCall> getServiceCallsByAddress(int addrId);
}
