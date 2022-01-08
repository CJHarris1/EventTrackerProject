package com.skilldistillery.servicecalls.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public List<ServiceCall> getServiceCallByDateScheduled(LocalDate date) {
		return scRepo.findByDateScheduled(date);
	}

	@Override
	public List<ServiceCall> getServiceCallByDateCalled(LocalDate date) {
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
	public boolean deleteServiceCall(int scId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ServiceCall getServiceCallByDateAndTime(LocalDate date, LocalTime time) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ServiceCall> getServiceCallByCustomerId(int custId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ServiceCall> getServiceCallByAddressId(int addrId) {
		// TODO Auto-generated method stub
		return null;
	}

}
