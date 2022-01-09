package com.skilldistillery.servicecalls.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.servicecalls.entities.Equipment;
import com.skilldistillery.servicecalls.repositories.EquipmentRepository;

@Service
public class EquipmentServiceImpl implements EquipmentService{

	@Autowired
	private EquipmentRepository equipRepo;
			
	@Override
	public List<Equipment> getEquipmentByAddress(int addrId) {
		return equipRepo.findByAddress_Id(addrId);
	}

	@Override
	public Equipment createNewEquipment(Equipment equip) {
		return equipRepo.saveAndFlush(equip);
	}

	@Override
	public boolean deleteEquipment(String equipId) {
		boolean deletedEquipment = false;
		Optional<Equipment> op = equipRepo.findById(equipId);
		if(op.isPresent()) {
			equipRepo.deleteById(equipId);
			deletedEquipment = true;
		}
		return deletedEquipment;
	}
	
	@Override
	public Equipment updateEquipment(Equipment equip, String equipId) {
		equip.setSerialNumber(equipId);
		if(equipRepo.existsById(equipId)) {
			return equipRepo.save(equip);
		}
		return null;
	}

}
