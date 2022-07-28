package com.learnspring.springdemo;

import java.util.Random;

public class HappyFortuneService implements FortuneService {
	
	@Override
	public String getFortune() {
		
		Random rnd = new Random();
		return "A great fortune for u";
	}

}
