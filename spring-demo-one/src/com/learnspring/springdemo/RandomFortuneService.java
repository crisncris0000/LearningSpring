package com.learnspring.springdemo;

import java.util.Random;

public class RandomFortuneService implements FortuneService{
	
	
	String[] fortunes = {"Today is your lucky day", "Today is a bad day for you", "A regular fortune for you"};
	@Override
	public String getFortune() {
		Random rnd = new Random();
		return fortunes[rnd.nextInt(3) + 0];
	}

}
