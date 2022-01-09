package com.skilldistillery.servicecalls.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.servicecalls.entities.ServiceCall;
import com.skilldistillery.servicecalls.repositories.ServiceCallsRepository;

@Service
public class ServiceCallsServiceImpl implements ServiceCallsService {
	
	@Autowired
	private ServiceCallsRepository scRepo;

	@Override
	public List<ServiceCall> getAllServiceCalls() {
		return scRepo.findAll();
	}

	@Override
	public List<ServiceCall> getServiceCallsByDateScheduled(LocalDate date) {
		return scRepo.findByDateScheduled(date);
	}

	@Override
	public List<ServiceCall> getServiceCallsByDateCalled(LocalDate date) {
		return scRepo.findByDateCalled(date);
	}

	@Override
	public ServiceCall createNewServiceCall(ServiceCall sc) {
		//will need to create new customer, the address, then service call
		scRepo.saveAndFlush(sc);
		return null;
	}

	@Override
	public ServiceCall updateServiceCall(int scId, ServiceCall sc) {
		sc.setId(scId);
		if(scRepo.existsById(scId)) {
			return scRepo.save(sc);
		}
		return null;
	}

	@Override
	public ServiceCall deleteServiceCall(int scId) {
		ServiceCall call;
		try {
			call = scRepo.findById(scId).get();
			call.setActive(false);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("invalid service call id");
			call = null;
		}
		return call;
	}

	@Override
	public ServiceCall getServiceCallByDateAndTime(LocalDate date, int time) {
		return scRepo.findByDateScheduledAndTimeSlot(date, time);
	}

	@Override
	public List<ServiceCall> getServiceCallsByCustomer(int custId) {
		return scRepo.findByCustomer_Id(custId);
	}

	@Override
	public List<ServiceCall> getServiceCallsByAddress(int addrId) {
		return scRepo.findByAddress_Id(addrId);
	}

}
