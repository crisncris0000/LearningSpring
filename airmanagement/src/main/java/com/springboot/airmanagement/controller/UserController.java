package com.springboot.airmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.airmanagement.entity.BookFlight;
import com.springboot.airmanagement.entity.User;
import com.springboot.airmanagement.service.BookFlightService;
import com.springboot.airmanagement.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	BookFlightService flightService;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/home")
	public String homePage() {
		return "index";
	}
	
	@GetMapping("/news")
	public String newsPage() {
		return "news";
	}
	
	@GetMapping("/login")
	public String loginForm(){
		return "login-form";
	}
	
	@GetMapping("/bookFlight")
	public String bookFlight() {
		return "book-flight";
	}
	
	@GetMapping("/flights")
	public String listFlights(Model model) {
		model.addAttribute("flights", flightService.getFlights());
		return "list-flights";
	}
	
	@GetMapping("/flight/new")
	public String createFlight(Model model) {
		BookFlight flight = new BookFlight();
		
		model.addAttribute("flight", flight);
		
		return "book-flight";
	}
	
	@PostMapping("/flights")
	public String saveFlight(@ModelAttribute("flight") BookFlight flight) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		flight.setStatus("CONFIRMED");
		
		flight.setUser(userService.findUserByName(auth.getName()));
		
		flightService.saveFlight(flight);
		
		
		return "redirect:/home";
	}
	
	
	
}
