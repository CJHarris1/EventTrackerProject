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
	public Address getAddressByStreetAddress(String street) {
		return addrRepo.findByAddress(street);
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
	public Address getAddressByCustomer(int custId) {
		return addrRepo.findByCustomerId(custId);
	}

	@Override
	public Address createNewAddress(int addrId, Address address) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Address updateAddress(int addrId, Address address) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
