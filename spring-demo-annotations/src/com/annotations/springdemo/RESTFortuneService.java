package com.annotations.springdemo;

import org.springframework.stereotype.Component;

@Component("restFortuneService")
public class RESTFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		return "Rest service";
	}

}
