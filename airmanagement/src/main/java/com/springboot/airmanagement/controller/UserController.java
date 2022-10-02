package com.springboot.airmanagement.controller;

import com.springboot.airmanagement.entity.News;
import com.springboot.airmanagement.service.NewsService;
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
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
	
	@Autowired
	BookFlightService flightservice;

	@Autowired
	NewsService newsService;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/home")
	public String homePage() {
		return "index";
	}
	
	@GetMapping("/news")
	public String newsPage(Model model) {

		model.addAttribute("posts", newsService.getPosts());

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
		model.addAttribute("flights", flightservice.getFlights());
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

		flightservice.saveFlight(flight);


		return "redirect:/home";
	}

	@GetMapping("/flight/delete")
	public String deleteFlight(@RequestParam("flightId") int id, Model model) {

		BookFlight flight = flightservice.findFlightById(id);

		News news = new News();

		news.setPost("Flight that is heading from " + flight.getDeparture() + " to " + flight.getDestination() +
				" has been canceled");

		model.addAttribute("post", news);

		newsService.save(news);

		flightservice.deleteFlight(flight);

		return "redirect:/flights";
	}
	
	
	
}
