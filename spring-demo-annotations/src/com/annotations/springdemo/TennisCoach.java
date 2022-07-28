package com.annotations.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
	
	@Autowired
	@Qualifier("superFortuneService")
	private FortuneService fortuneService;
	
	// default constructor
	
	public TennisCoach() {
		System.out.println("Tennis coach!");
	}
	
	// Using autowired in a setter method
//	@Autowired
//	public void tellMyFortune(FortuneService fortuneService) {
//		System.out.println("inside a method");
//		this.fortuneService = fortuneService;
//	}
	
	
//	@Autowired
//	public TennisCoach(FortuneService fortuneService) {
//		this.fortuneService = fortuneService;
//	}
	
	@PostConstruct
	public void startupStuff() {
		System.out.println("Starting stuff...");
	}
	
	@PreDestroy
	public void destroyStuff() {
		System.out.println("Destroying stuff...");
	}
	
	
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
