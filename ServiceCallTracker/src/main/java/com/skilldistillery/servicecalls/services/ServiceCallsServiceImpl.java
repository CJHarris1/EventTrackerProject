package com.skilldistillery.servicecalls.services;

import java.time.LocalDate;
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
	public ServiceCall getServiceCallByDateScheduled(LocalDate date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceCall getServiceCallByDateCalled(LocalDate date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceCall createNewServiceCall(int scId, ServiceCall sc) {
		// TODO Auto-generated method stub
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

}
