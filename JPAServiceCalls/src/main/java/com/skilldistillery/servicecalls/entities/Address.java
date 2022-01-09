package com.skilldistillery.servicecalls.entities;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String address;
	
	private String city;
	
	@Column(name = "state_abbv")
	private String stateAbbv;
	
	@JsonIgnore
	@OneToMany(mappedBy = "address")
	private List<ServiceCall> serviceCalls;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@JsonIgnore
	@OneToMany(mappedBy = "address")
	private List<Equipment> equipment;
	
	public Address() {}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStateAbbv() {
		return stateAbbv;
	}

	public void setStateAbbv(String stateAbbv) {
		this.stateAbbv = stateAbbv;
	}

	public List<ServiceCall> getServiceCalls() {
		return serviceCalls;
	}

	public void setServiceCalls(List<ServiceCall> serviceCalls) {
		this.serviceCalls = serviceCalls;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Equipment> getEquipment() {
		return equipment;
	}

	public void setEquipment(List<Equipment> equipment) {
		this.equipment = equipment;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", address=" + address + ", city=" + city + ", stateAbbv=" + stateAbbv + "]";
	}
	
	
}
