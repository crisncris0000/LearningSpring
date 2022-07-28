package com.learnspring.springdemo;

public class CricketCoach implements Coach{
	
	private FortuneService fortuneService;
	
	private String emailAddress;
	private String team;
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
		System.out.println("Email: setter method");
	}
	
	public String getEmail() {
		return emailAddress;
	}

	public void setTeam(String team) {
		this.team = team;
		System.out.println("Team: setter method");
	}
	
	public String getTeam() {
		return team;
	}

	public CricketCoach(){
		System.out.println("Cricket Coach!");
	}
	
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Cricket coach: setter method");
		this.fortuneService = fortuneService;
	}


	@Override
	public String getDailyWorkout() {
		return "Practice fast bowling for 15 min";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	
	
	
}
