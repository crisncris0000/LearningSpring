package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = new 
				AnnotationConfigApplicationContext(DemoConfig.class);
		
		
		// get bean from spring container
		AccountDAO accountDAO = 
				context.getBean("accountDAO", AccountDAO.class);
		
		
		// call the business method
		Account account = new Account();
		accountDAO.addAccount(account, false);
		accountDAO.doWork();  
		
		// call the membership business method
		MembershipDAO membership = 
				context.getBean("membershipDAO", MembershipDAO.class);
		
		membership.addAccountMember();
		membership.goSleep();
		
		// close context
		context.close();
		
	}
	
}
