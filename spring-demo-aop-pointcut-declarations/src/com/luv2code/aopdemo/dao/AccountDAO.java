package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {

	
	public void addAccount(Account theAccount, boolean vipFlas) {
		System.out.println(getClass() + ": Doing my DB work: ADDING ACCOUNT");
	}
	
	public boolean doWork() {
		System.out.println(getClass() + " Performing some work");
		return false;
	}
	
}
