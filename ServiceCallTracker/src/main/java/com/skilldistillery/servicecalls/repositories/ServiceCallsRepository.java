package com.skilldistillery.servicecalls.repositories;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.servicecalls.entities.ServiceCall;

public interface ServiceCallsRepository extends JpaRepository<ServiceCall, Integer> {

	List<ServiceCall> findByDateScheduled(LocalDate date);
	
	List<ServiceCall> findByDateCalled(LocalDate date);
	
	ServiceCall findByDateScheduledAndTimeSlot(LocalDate date, LocalTime time);
}
