package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;
	
	// add a new method: findAccounts()
	
	public List<Account> findAccounts(boolean tripWire){
		
		// throwing an exception on purpose to test afterThrowing
		if(tripWire == true) {
			throw new RuntimeException("Exception has been thrown!!!!!");
		}
		
		
		List<Account> accounts = new ArrayList<>();
		
		// create sample accounts
		Account tempAccount = new Account("John", "Silver");
		Account tempAccount2 = new Account("Chris", "Diamond");
		Account tempAccount3 = new Account("Ivan", "Bronze");
		
		// add them to the list
		accounts.add(tempAccount);
		accounts.add(tempAccount2);
		accounts.add(tempAccount3);
		
		return accounts;
	}
	
	
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
