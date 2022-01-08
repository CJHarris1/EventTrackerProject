package com.skilldistillery.servicecalls.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.servicecalls.entities.Address;
import com.skilldistillery.servicecalls.entities.Customer;
import com.skilldistillery.servicecalls.entities.ServiceCall;
import com.skilldistillery.servicecalls.repositories.ServiceCallsRepository;

@Service
public class ServiceCallsServiceImpl implements ServiceCallsService {
	
	@Autowired
	private ServiceCallsRepository scRepo;

	@Override
	public List<ServiceCall> getAllServiceCalls() {
		return scRepo.findAll();
	}

	@Override
	public List<ServiceCall> getServiceCallsByDateScheduled(LocalDate date) {
		return scRepo.findByDateScheduled(date);
	}

	@Override
	public List<ServiceCall> getServiceCallsByDateCalled(LocalDate date) {
		return scRepo.findByDateCalled(date);
	}

	@Override
	public ServiceCall createNewServiceCall(int scId, ServiceCall sc) {
		//will need to create new customer, the address, then service call
		return null;
	}

	@Override
	public ServiceCall updateServiceCall(int scId, ServiceCall sc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceCall deleteServiceCall(int scId) {
		ServiceCall call = scRepo.findById(scId).get();
		call.setActive(false);
		return call;
	}

	@Override
	public ServiceCall getServiceCallByDateAndTime(LocalDate date, int time) {
		return scRepo.findByDateScheduledAndTimeSlot(date, time);
	}

	@Override
	public List<ServiceCall> getServiceCallsByCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ServiceCall> getServiceCallsByAddress(Address address) {
		// TODO Auto-generated method stub
		return null;
	}

}
