package com.skilldistillery.servicecalls.services;

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
	public List<ServiceCall> getAllCustomers() {
		return scRepo.findAll();
	}

	@Override
	public ServiceCall getCustomerById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceCall createNewCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

}
