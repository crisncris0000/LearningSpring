package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	
	
	@AfterThrowing(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
				   throwing = "throwExc")
	public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable throwExc) {
		
		// print out which method we are advising on
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n====> Executing @AfterThrowing on method " + method);
		
		// log the expression
		System.out.println("\n=====> The exception is: " + throwExc);
		
	}
	
	
	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n====> Executing @After (finally) on method " + method);
	}
	
	@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws  Throwable{
		
		// print out method we are advising on
		String method = proceedingJoinPoint.getSignature().toShortString();
		System.out.println("\n====> Executing @Around on method " + method);
		
		// get begin timestamp
		long begin = System.currentTimeMillis();
		// execute the method
		
		Object result = proceedingJoinPoint.proceed(); 
		// get end timestamp
		
		long end = System.currentTimeMillis();
		
		// compute duration and display it
		
		long duration = end - begin;
		
		System.out.println("\n======> Duration is " + duration / 1000.0 + " seconds");
		
		return result;
	}
	
	
}
