package com.skilldistillery.servicecalls.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.servicecalls.services.AddressService;

@RestController
@RequestMapping("api")
public class AddressController {

	@Autowired
	private AddressService addrServ;
	
	
}
