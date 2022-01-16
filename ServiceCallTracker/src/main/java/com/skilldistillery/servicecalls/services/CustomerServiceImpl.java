package com.skilldistillery.servicecalls.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public Customer createNewCustomer(Customer cust) {
		return custRepo.saveAndFlush(cust);
	}

	@Override
	public Customer updateCustomer(int custId, Customer cust) {
		cust.setId(custId);
		if(custRepo.existsById(custId)) {
			return custRepo.save(cust);
		}
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
	public List<Customer> getCustomerByFullName(String fName, String lName) {
		return custRepo.findByFirstNameAndLastName(fName, lName);
	}

	
}
