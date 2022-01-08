package com.skilldistillery.servicecalls.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.servicecalls.entities.ServiceCall;

public interface ServiceCallsRepository extends JpaRepository<ServiceCall, Integer> {

}
