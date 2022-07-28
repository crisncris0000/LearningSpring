package com.annotations.springdemo;

import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SuperFortuneService implements FortuneService {

	@Value("${foo.fortunes}")
	private String[] arr;
	
	@Override
	public String getFortune() {
		Random random = new Random();
		
		return arr[random.nextInt(arr.length)];
	}
	
	@PostConstruct
	public void readFortunes() {
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
