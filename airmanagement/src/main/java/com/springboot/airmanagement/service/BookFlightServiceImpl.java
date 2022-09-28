package com.springboot.airmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.airmanagement.entity.BookFlight;
import com.springboot.airmanagement.repository.FlightRepository;

@Service
public class BookFlightServiceImpl implements BookFlightService{
	
	
	private FlightRepository repository;
	
	@Autowired
	public BookFlightServiceImpl(FlightRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public List<BookFlight> getFlights() {
		return repository.findAll();
	}

	@Override
	public void saveFlight(BookFlight flight) {
		repository.save(flight);
	}

	@Override
	public void deleteFlight(BookFlight flight) {
		repository.delete(flight);
	}

	
	
}
