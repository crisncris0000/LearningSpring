package com.springboot.airmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.acls.model.NotFoundException;
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

	@Override
	public BookFlight findFlightById(int id) {

		Optional<BookFlight> result = repository.findById(id);
		BookFlight flight = null;

		if(result.isPresent()) {
			flight = result.get();
		} else {
			throw new NotFoundException("Flight not found");
		}



		return flight;
	}

	
}
