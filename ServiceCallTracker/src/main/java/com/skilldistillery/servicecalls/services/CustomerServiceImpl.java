package com.skilldistillery.servicecalls.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.servicecalls.entities.Address;
import com.skilldistillery.servicecalls.entities.Customer;
import com.skilldistillery.servicecalls.repositories.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository custRepo;

	@Override
	public List<Customer> getAllCustomers() {
		return custRepo.findAll();
	}

	@Override
	public Customer createNewCustomer(int custId, Customer cust) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer updateCustomer(int custId, Customer cust) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getCustomerByFirstName(String name) {
		return custRepo.findByFirstName(name);
	}

	@Override
	public List<Customer> getCustomerLastName(String name) {
		return custRepo.findByLastName(name);
	}

	@Override
	public Customer getCustomerPhoneNumber(String phoneNumber) {
		return custRepo.findByPhoneNumber(phoneNumber);
	}

	@Override
	public Customer getCustomerByAddress(Address address) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
