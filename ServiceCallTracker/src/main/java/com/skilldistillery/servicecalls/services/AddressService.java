package com.skilldistillery.servicecalls.services;

import java.util.List;

import com.skilldistillery.servicecalls.entities.Address;

public interface AddressService {
	
	List<Address> getAllAddresses();
	
	Address getAddressByStreetAddress(String street);
	
	List<Address> getAddressByCity(String city);
	
	List<Address> getAddressByStateAbbv(String stateAbbv);
	
	Address getAddressByCustomer(int custId);
	
	Address createNewAddress(int addrId, Address address);
	
	Address updateAddress(int addrId, Address address);

}
