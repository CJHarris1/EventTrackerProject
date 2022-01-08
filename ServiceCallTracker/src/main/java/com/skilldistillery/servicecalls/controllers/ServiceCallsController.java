package com.skilldistillery.servicecalls.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PutMapping("servicecalls/{scId}")
	public ServiceCall serviceCallCompleted(@PathVariable int scId) {
		return scService.deleteServiceCall(scId);
	}
	
	@GetMapping("servicecalls/datescheduled/{date}/time/{time}")
	public ServiceCall getCallByDateScheduledAndTime(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate date,
													 @PathVariable int time) {
		return scService.getServiceCallByDateAndTime(date, time);
	}
}
