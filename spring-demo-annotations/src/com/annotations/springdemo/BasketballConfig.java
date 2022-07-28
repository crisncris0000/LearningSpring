package com.annotations.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BasketballConfig {

	@Bean
	public FortuneService interestingFortuneService() {
		return new InterestingFortuneService();
	}
	
	@Bean
	public Coach basketballCoach() {
		return new BasketballCoach(interestingFortuneService());
	}
	
	
}
