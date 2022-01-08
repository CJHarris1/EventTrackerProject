package com.skilldistillery.servicecalls.entities;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "service_call")
public class ServiceCall {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String description;
	
	@Column(name = "date_called")
	private LocalDateTime dateCalled;
	
	@Column(name = "date_scheduled")
	private LocalDateTime dateScheduled;
	
	@Column(name = "time_slot")
	private LocalDateTime timeSlot;
	
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

	public LocalDateTime getDateCalled() {
		return dateCalled;
	}

	public void setDateCalled(LocalDateTime dateCalled) {
		this.dateCalled = dateCalled;
	}

	public LocalDateTime getDateScheduled() {
		return dateScheduled;
	}

	public void setDateScheduled(LocalDateTime dateScheduled) {
		this.dateScheduled = dateScheduled;
	}

	public LocalDateTime getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(LocalDateTime timeSlot) {
		this.timeSlot = timeSlot;
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
				+ ", dateScheduled=" + dateScheduled + ", timeSlot=" + timeSlot + "]";
	}

	
}
