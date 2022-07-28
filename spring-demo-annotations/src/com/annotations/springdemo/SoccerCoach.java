package com.annotations.springdemo;

import org.springframework.stereotype.Component;

@Component
public class SoccerCoach  implements Coach{

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Kick 50 balls inside the net";
	}

	@Override
	public String getDailyFortune() {
		return null;
	}

}
