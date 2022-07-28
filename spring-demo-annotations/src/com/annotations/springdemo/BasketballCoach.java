package com.annotations.springdemo;

public class BasketballCoach implements Coach{

	FortuneService fortuneService;
	
	public BasketballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	
	
	@Override
	public String getDailyWorkout() {
		return "Practice you're dribble for 50 min";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
