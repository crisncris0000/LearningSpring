package com.learnspring.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		
		boolean result = theCoach == alphaCoach;
		
		System.out.println("pointing to same reference: " + result);
		
		System.out.println("Memory location theCoach" + theCoach);
		System.out.println("Memory location alphaCoach" + alphaCoach);
		
		
		context.close();
	}

	
	
	
}


