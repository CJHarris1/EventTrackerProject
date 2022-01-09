package com.skilldistillery.servicecalls.services;

import java.util.List;

import com.skilldistillery.servicecalls.entities.Address;

public interface AddressService {
	
	List<Address> getAllAddresses();
	
	List<Address> getAddressByCity(String city);
	
	List<Address> getAddressByStateAbbv(String stateAbbv);
	
	List<Address> getAddressByCustomer(int custId);
	
	Address createNewAddress(Address address);
	
	Address updateAddress(int addrId, Address address);

}
