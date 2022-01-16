package com.skilldistillery.servicecalls.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.servicecalls.entities.ServiceCall;

public interface ServiceCallsRepository extends JpaRepository<ServiceCall, Integer> {

	List<ServiceCall> findByDateScheduled(LocalDate date);
	
	List<ServiceCall> findByDateCalled(LocalDate date);
	
	List<ServiceCall> findByAddress_Id(int addrId);
	
	List<ServiceCall> findByActive(Boolean active);
}
