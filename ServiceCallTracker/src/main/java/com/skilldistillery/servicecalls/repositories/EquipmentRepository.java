package com.skilldistillery.servicecalls.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.servicecalls.entities.Equipment;

public interface EquipmentRepository extends JpaRepository<Equipment, String>{
// could add feature to search equipment by type or fuel type
	
	List<Equipment> findByAddress_Id(int addrId);
}
