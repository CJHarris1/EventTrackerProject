package com.skilldistillery.servicecalls.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public List<Customer> getCustomersByFirstName(@PathVariable String fName, HttpServletResponse res){
		List<Customer> custs = custServ.getCustomerByFirstName(fName);
		if(custs.size() == 0) {
			res.setStatus(404);
		}
		return custs;
	}
	
	@GetMapping("customers/lastname/{lName}")
	public List<Customer> getCustomersByLastName(@PathVariable String lName, HttpServletResponse res){
		List<Customer> custs = custServ.getCustomerLastName(lName);
		if(custs.size() == 0) {
			res.setStatus(404);
		}
		return custs;
	}
	
	@GetMapping("customers/phonenumber/{phone}")
	public Customer getCustomerByPhoneNumber(@PathVariable String phone, HttpServletResponse res) {
		Customer cust = custServ.getCustomerPhoneNumber(phone);
		if(cust == null) {
			res.setStatus(404);
		}
		return cust;
	}
	
	@PostMapping("customers")
	public Customer createNewCustomer(@RequestBody Customer cust, HttpServletResponse res, HttpServletRequest req) {
		try {
			cust = custServ.createNewCustomer(cust);
			res.setStatus(201);
			StringBuffer url = req.getRequestURL();
			url.append("/").append(cust.getId());
			res.setHeader("Location", url.toString());
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Invalid Customer sent");
			res.setStatus(400);
			cust = null;
		}
		return cust;
	}
	
	@PutMapping("customers/{custId}")
	public Customer updateCustomer(@PathVariable int custId, HttpServletResponse res, @RequestBody Customer cust) {
		try {
			cust = custServ.updateCustomer(custId, cust);
			if(cust == null) {
				res.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			cust = null;
		}
		return cust;
	}
}
