package com.springboot.airmanagement.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "book_flight")
public class BookFlight {
	
	@Id
	@Column(name = "id")
	int id;
	
	@Column(name = "destination")
	private String destination;
	
	@Column(name = "departure")
	private String departure;
	
	@Column(name = "status")
	private String status;

	@OneToOne(cascade = {CascadeType.DETACH, 
			 CascadeType.MERGE,
			 CascadeType.REFRESH,
			 CascadeType.MERGE})
	@JoinColumn(name = "username")
	private User user;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "BookFlight [destination=" + destination + ", departure=" + departure + ", status=" + status + "]";
	}
	
	
	
}
