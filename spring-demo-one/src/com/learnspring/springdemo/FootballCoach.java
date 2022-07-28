package com.learnspring.springdemo;

public class FootballCoach implements Coach{
	
	private FortuneService fortuneService;
	
	public FootballCoach() {}
	public FootballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Catch the football, throw the football";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return "CATCH THE BALL "+ fortuneService.getFortune();
	}
	
	
	public void enable() {
		System.out.println("Method enabled!");
	}
	
	public void destroy() {
		System.out.println("Method destroyed!!!");
	}
	
}
