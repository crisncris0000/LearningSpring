package com.annotations.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		Coach alplaCoach = context.getBean("tennisCoach", Coach.class);
		
		
		System.out.println(theCoach == alplaCoach);
		
		context.close();
	}

}
