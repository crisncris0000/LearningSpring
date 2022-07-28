package com.annotations.springdemo;

public class InterestingFortuneService implements FortuneService{

	@Override
	public String getFortune() {
		return "The sky is blue";
	}
	
	
}
