package com.springboot.airmanagement.service;

import java.util.List;

import com.springboot.airmanagement.entity.BookFlight;
import com.springboot.airmanagement.repository.FlightRepository;

public interface BookFlightService {

	public List<BookFlight> getFlights();
	
	public void saveFlight(BookFlight flight);
	
	public void deleteFlight(BookFlight flight);
	
	
}
