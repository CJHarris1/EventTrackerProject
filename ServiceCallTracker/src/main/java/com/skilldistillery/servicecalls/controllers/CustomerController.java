package com.skilldistillery.servicecalls.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.servicecalls.entities.Customer;
import com.skilldistillery.servicecalls.services.CustomerService;

@RestController
@RequestMapping("api")
public class CustomerController {

	@Autowired
	private CustomerService custServ;
	
	@GetMapping("customers")
	public List<Customer> getAllCustomers(){
		return custServ.getAllCustomers();
	}
	
	@GetMapping("customers/firstname/{fName}")
	public List<Customer> getCustomersByFirstName(@PathVariable String fName){
		return custServ.getCustomerByFirstName(fName);
	}
	
	@GetMapping("customers/lastname/{lName}")
	public List<Customer> getCustomersByLastName(@PathVariable String lName){
		return custServ.getCustomerLastName(lName);
	}
	
	@GetMapping("customers/phonenumber/{phone}")
	public Customer getCustomerByPhoneNumber(@PathVariable String phone) {
		return custServ.getCustomerPhoneNumber(phone);
	}
	
	
}
