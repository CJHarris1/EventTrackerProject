package com.skilldistillery.servicecalls.controllers;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.servicecalls.entities.ServiceCall;
import com.skilldistillery.servicecalls.services.ServiceCallsService;

@RestController
@RequestMapping("api")
public class ServiceCallsController {
	
	@Autowired
	private ServiceCallsService scService;
	
	@GetMapping("servicecalls")
	public List<ServiceCall> getAllCalls(){
		return scService.getAllServiceCalls();
	}
	
	@GetMapping("servicecalls/datescheduled/{date}")
	public List<ServiceCall> getCallByDateScheduled(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate date){
		return scService.getServiceCallsByDateScheduled(date);
	}
	
	@GetMapping("servicecalls/datecalled/{date}")
	public List<ServiceCall> getCallByDateCalled(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date){
		return scService.getServiceCallsByDateCalled(date);
	}
	
	@PostMapping("servicecalls")
	public ServiceCall createNewServiceCall(@RequestBody ServiceCall sc, HttpServletResponse res, HttpServletRequest req) {
		try {
			sc = scService.createNewServiceCall(sc);
			res.setStatus(201);
			StringBuffer url = req.getRequestURL();
			url.append("/").append(sc.getId());
			res.setHeader("Location", url.toString());
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Invalid service call sent");
			res.setStatus(400);
			sc = null;
		}
		return sc;
	}
	
	@PutMapping("servicecalls/{scId}")
	public ServiceCall updateServiceCall(@PathVariable int scId, HttpServletResponse res, @RequestBody ServiceCall sc) {
		try {
			sc = scService.updateServiceCall(scId, sc);
			if (sc == null) {
				res.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			sc = null;
		}
		return sc;
	}
	
	@PutMapping("servicecalls/completed/{scId}")
	public ServiceCall serviceCallCompleted(@PathVariable int scId, HttpServletResponse res) {
		ServiceCall sc = scService.deleteServiceCall(scId);
		if(sc == null) {
			res.setStatus(404);
		}
		return sc;
	}
	
	@GetMapping("servicecalls/datescheduled/{date}/time/{time}")
	public ServiceCall getCallByDateScheduledAndTime(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate date,
													 @PathVariable int time) {
		return scService.getServiceCallByDateAndTime(date, time);
	}
	
	@GetMapping("servicecalls/customer/{custId}")
	public List<ServiceCall> getCallByCustomerId(@PathVariable int custId) {
		return scService.getServiceCallsByCustomer(custId);
	}
	
	@GetMapping("servicecalls/address/{addrId}")
	public List<ServiceCall> getCallByAddressId(@PathVariable int addrId){
		return scService.getServiceCallsByAddress(addrId);
	}
}
