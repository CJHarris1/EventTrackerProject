package com.skilldistillery.servicecalls.services;

import java.time.LocalDate;
import java.util.List;

import com.skilldistillery.servicecalls.entities.ServiceCall;

public interface ServiceCallsService {

	List<ServiceCall> getAllServiceCalls();
	
	ServiceCall getServiceCallByDateScheduled(LocalDate date);
	
	ServiceCall getServiceCallByDateCalled(LocalDate date);
	
	ServiceCall createNewServiceCall(int scId, ServiceCall sc);
	
	ServiceCall updateServiceCall(int scId, ServiceCall sc);
	
	boolean deleteServiceCall(int scId);
}
