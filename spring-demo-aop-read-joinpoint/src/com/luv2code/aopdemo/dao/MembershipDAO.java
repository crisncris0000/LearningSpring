package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public void addAccountMember() {
		System.out.println(getClass() + " : Adding you to our membership program!");
	}
	
	public void goSleep() {
		System.out.println(getClass() + " going to sleep peace out");
	}
	
	
}
