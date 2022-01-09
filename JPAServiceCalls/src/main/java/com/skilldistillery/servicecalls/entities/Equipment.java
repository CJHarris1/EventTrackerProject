package com.skilldistillery.servicecalls.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Equipment {

	@Id
	@Column(name = "serial_number")
	private String serialNumber;
	
	@Column(name = "model_number")
	private String modelNumber;
	
	private String type;
	
	@Column(name = "fuel_type")
	private String fuelType;
	
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "address_id")
	private Address address;

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getModelNumber() {
		return modelNumber;
	}

	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		return Objects.hash(serialNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipment other = (Equipment) obj;
		return Objects.equals(serialNumber, other.serialNumber);
	}

	@Override
	public String toString() {
		return "Equipment [serialNumber=" + serialNumber + ", modelNumber=" + modelNumber + ", type=" + type
				+ ", fuelType=" + fuelType + ", description=" + description + ", address=" + address + "]";
	}
	
}
