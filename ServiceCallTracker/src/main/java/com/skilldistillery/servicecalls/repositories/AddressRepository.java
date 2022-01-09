package com.skilldistillery.servicecalls.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.servicecalls.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{

	List<Address> findByCity(String city);
	
	List<Address> findByStateAbbv(String stateAbbv);
	
	List<Address> findByCustomerId(int custId);
}
