package com.springboot.airmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.airmanagement.entity.BookFlight;

public interface FlightRepository extends JpaRepository<BookFlight, Integer>{

}
