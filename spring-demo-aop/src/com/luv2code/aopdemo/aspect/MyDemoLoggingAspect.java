package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// this is where we add all of our related advices for logging
	
	// start with an @Before advice
	
	/*
	
	@Before("execution(public void addAccount())")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n====>> Executing @Before advice on addAccount");
		
	}
	
	*/
	
	// using before on an addAccount from a SPECIFIC class
	/*
	@Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n====>> Executing @Before advice on addAccount");
		
	}
	*/
	
	// Any method that starts with add
	/*
	@Before("execution(public void add*())")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n====>> Executing @Before advice on addAccount");
		
	}
	*/
	
	// Any method with any return type an also specify other return types list, string, int etc.
	@Before("execution(* add*())")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n====>> Executing @Before advice on addAccount");
		
	}
	
}
