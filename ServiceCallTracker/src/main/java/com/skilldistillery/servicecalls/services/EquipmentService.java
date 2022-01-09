package com.skilldistillery.servicecalls.services;

import java.util.List;

import com.skilldistillery.servicecalls.entities.Equipment;

public interface EquipmentService {

	//List<Equipment> getEquipmentBySerialNumber(String serial); add if have extra time
	
	//List<Equipment> getEquipmentByModelNumber(String model); add if have extra time
	
	List<Equipment> getEquipmentByAddress(int addrId);
	
	Equipment createNewEquipment(Equipment equip);
	
	boolean deleteEquipment(String equipId);
	
	Equipment updateEquipment(Equipment equip, String equipId);
}
