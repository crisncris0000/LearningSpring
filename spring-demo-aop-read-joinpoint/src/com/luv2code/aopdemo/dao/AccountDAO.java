package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;
	
	public void addAccount(Account theAccount, boolean vipFlas) {
		System.out.println(getClass() + ": Doing my DB work: ADDING ACCOUNT");
	}
	
	public boolean doWork() {
		System.out.println(getClass() + " Performing some work");
		return false;
	}

	public String getName() {
		System.out.println("Getting name...");
		return name;
	}

	public void setName(String name) {
		System.out.println("Setting name...");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println("Getting service code...");

		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println("Setting service code...");
		this.serviceCode = serviceCode;
	}
	
}
