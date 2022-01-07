package com.skilldistillery.servicecalls.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.servicecalls.entities.Customer;
import com.skilldistillery.servicecalls.repositories.ServiceCallsRepository;

@Service
public class ServiceCallsServiceImpl implements ServiceCallsService {
	
	@Autowired
	private ServiceCallsRepository scRepo;

	@Override
	public List<Customer> getAllCustomers() {
		return scRepo.findAll();
	}

	@Override
	public Customer getCustomerById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer createNewCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

}
