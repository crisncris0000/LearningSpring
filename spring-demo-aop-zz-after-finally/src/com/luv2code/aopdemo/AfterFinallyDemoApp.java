package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class AfterFinallyDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = new 
				AnnotationConfigApplicationContext(DemoConfig.class);
		
		// call method to find the accounts
		
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		List<Account> theAccounts = null;
		
		try {
			// add boolean flag to simulate exceptions
			boolean tripWire = false;
			theAccounts = accountDAO.findAccounts(tripWire);
		} catch (Exception exc) {
			System.out.println("\nMain program caught exception: " + exc);
		}
		
		
			System.out.println("\nMain program: " + theAccounts);
		
		
		// close context
		context.close();
		
	}
	
}
