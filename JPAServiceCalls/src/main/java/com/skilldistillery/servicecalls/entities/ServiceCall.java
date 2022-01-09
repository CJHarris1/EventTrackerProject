package com.skilldistillery.servicecalls.entities;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "service_call")
public class ServiceCall {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String description;
	
	@Column(name = "date_called")
	private LocalDate dateCalled;
	
	@Column(name = "date_scheduled")
	private LocalDate dateScheduled;
	
	@Column(name = "time_slot")
	private int timeSlot;
	
	private boolean active;
	
	@ManyToOne
	@JoinColumn(name = "address_id")
	private Address address;
	

	
	public ServiceCall() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDateCalled() {
		return dateCalled;
	}

	public void setDateCalled(LocalDate dateCalled) {
		this.dateCalled = dateCalled;
	}

	public LocalDate getDateScheduled() {
		return dateScheduled;
	}

	public void setDateScheduled(LocalDate dateScheduled) {
		this.dateScheduled = dateScheduled;
	}

	public int getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(int timeSlot) {
		this.timeSlot = timeSlot;
	}
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
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
		ServiceCall other = (ServiceCall) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "ServiceCall [id=" + id + ", description=" + description + ", dateCalled=" + dateCalled
				+ ", dateScheduled=" + dateScheduled + ", timeSlot=" + timeSlot + ", active=" + active + "]";
	}

	
}
