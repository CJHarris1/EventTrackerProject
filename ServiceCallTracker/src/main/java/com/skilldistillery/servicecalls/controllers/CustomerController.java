package com.skilldistillery.servicecalls.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
		return custServ;
	}
}
