package com.skilldistillery.servicecalls.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.servicecalls.entities.ServiceCall;
import com.skilldistillery.servicecalls.services.ServiceCallsService;

@RestController
@RequestMapping("api")
public class ServiceCallsController {
	
	@Autowired
	private ServiceCallsService scService;
	
	
	@GetMapping("customers")
	public List<ServiceCall> index(){
		return scService.getAllCustomers();
	}
}
