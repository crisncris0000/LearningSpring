package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

	@Before("com.luv2code.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()") 
	public void beforeAddAccountAdvice(JoinPoint joinpoint) {
		System.out.println("\n====>> Executing @Before advice on addAccount");
		
		// display the method signature
		MethodSignature signature = (MethodSignature) joinpoint.getSignature();
		// display the method arguments
		System.out.println("Method: " + signature);
		
		// display method arguments
		
		// get args
		Object[] args = joinpoint.getArgs();
		
		// loop through args
		
		for (Object object : args) {
			System.out.println(object);
			
			if(object instanceof Account) {
				// downcast and print Account specific stuff
				Account account = (Account) object;
				
				System.out.println("Account name: " + account.getName());
				System.out.println("Account level: " + account.getLevel());
			}
		}
		
	}
	
	
	// add a new advice for @AfterReturning
	@AfterReturning(
			pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
		
		// print out which method we are advising from
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n ====> Executing @AfterReturning on method " + method);
		
		// print results of method call
		
		System.out.println("\n ====> result is... " + result);
		
		// lets post-process the data ... lets modify it
		
		// convert the accounts names to uppercase
		
		convertAccountNamesToUpperCase(result);
		
		System.out.println("ACCOUNTS UPPERCASE: " + result);
		
	}
	
	private void convertAccountNamesToUpperCase(List<Account> result) {
		// loop through accounts and uppercase them
		
		for (Account account : result) {
			String upperName = account.getName().toUpperCase();

			account.setName(upperName);
			
		}
		
	}
	
	
	
}
