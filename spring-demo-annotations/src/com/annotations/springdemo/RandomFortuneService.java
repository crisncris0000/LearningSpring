package com.annotations.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	String[] fortunes = {"Today is your lucky day", "Todays a bad day for you", "The journey is the reward"};
	@Override
	public String getFortune() {
		Random rnd = new Random();
		return fortunes[rnd.nextInt(fortunes.length)];
	}

}
