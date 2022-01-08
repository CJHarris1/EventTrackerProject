package com.skilldistillery.servicecalls.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.servicecalls.entities.ServiceCall;

public interface ServiceCallsRepository extends JpaRepository<ServiceCall, Integer> {

//	List<ServiceCall> findByDateScheduled();
//	
//	List<ServiceCall> findByDateCalled();
//	
//	ServiceCall findByDateScheduledAndTimeSlot();
}
