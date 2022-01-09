package com.skilldistillery.servicecalls.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.servicecalls.entities.Address;
import com.skilldistillery.servicecalls.repositories.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService{

	@Autowired
	private AddressRepository addrRepo;
	
	@Override
	public List<Address> getAllAddresses() {
		return addrRepo.findAll();
	}

	@Override
	public List<Address> getAddressByCity(String city) {
		return addrRepo.findByCity(city);
	}

	@Override
	public List<Address> getAddressByStateAbbv(String stateAbbv) {
		return addrRepo.findByStateAbbv(stateAbbv);
	}

	@Override
	public List<Address> getAddressByCustomer(int custId) {
		return addrRepo.findByCustomerId(custId);
	}

	@Override
	public Address createNewAddress(Address address) {
		addrRepo.saveAndFlush(address);
		return address;
	}

	@Override
	public Address updateAddress(int addrId, Address address) {
		if(addrRepo.existsById(addrId)) {
			return addrRepo.save(address);
		}
		return null;
	}

	
}
