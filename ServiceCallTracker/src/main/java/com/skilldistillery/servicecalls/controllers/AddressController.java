package com.skilldistillery.servicecalls.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.servicecalls.entities.Address;
import com.skilldistillery.servicecalls.services.AddressService;

@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost:4202"})
public class AddressController {

	@Autowired
	private AddressService addrServ;
	
	@GetMapping("address")
	public List<Address> getAllAddresses(){
		return addrServ.getAllAddresses();
	}
	
	@GetMapping("address/city/{city}")
	public List<Address> getAddressByCity(@PathVariable String city, HttpServletResponse res) {
		List<Address> addr = addrServ.getAddressByCity(city);
		if(addr.size() == 0) {
			res.setStatus(404);
		}
		return addr;
	}
	
	@GetMapping("address/state/{stateAbbv}")
	public List<Address> getAddressByStateAbbv(@PathVariable String stateAbbv, HttpServletResponse res){
		List<Address> addr = addrServ.getAddressByStateAbbv(stateAbbv);
		if(addr.size() == 0) {
			res.setStatus(404);
		}
		return addr;
	}
	
	@GetMapping("address/customer/{custId}")
	public List<Address> getAddressByCustomerId(@PathVariable int custId, HttpServletResponse res){
		List<Address> addr = addrServ.getAddressByCustomer(custId);
		if(addr.size() == 0) {
			res.setStatus(404);
		}
		return addr;
	}
	
	@PostMapping("address")
	public Address createNewAddress(@RequestBody Address addr, HttpServletResponse res, HttpServletRequest req) {
		try {
			addr = addrServ.createNewAddress(addr);
			res.setStatus(201);
			StringBuffer url = req.getRequestURL();
			url.append("/").append(addr.getId());
			res.setHeader("Location", url.toString());
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Invalid Address sent");
			res.setStatus(400);
			addr = null;
		}
		return addr;
	}
	
	@PutMapping("address/{addrId}")
	public Address updateAddress(@PathVariable int addrId, HttpServletResponse res, @RequestBody Address addr) {
		try {
			addr = addrServ.updateAddress(addrId, addr);
			if(addr == null) {
				res.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			addr = null;
		}
		return addr;
	}
	
	
}
