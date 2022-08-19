package com.luv2code.springboot.demo.myawesomeapp.rest;
import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	@GetMapping("/")
	public String sayHello() {
		return "Hello World! Time on the server is " + LocalDateTime.now();
	}
	
	// expose a new endpoint for "workout"
	@GetMapping("/workout")
	public String getDailyWorkout() {
		return "Jumping jacks 20x";
	}
	
	@GetMapping("/fortune")
	public String getDailyFortune() {
		return "Great things coming your way as long as you work hard";
	}
	
	
	
	
}
