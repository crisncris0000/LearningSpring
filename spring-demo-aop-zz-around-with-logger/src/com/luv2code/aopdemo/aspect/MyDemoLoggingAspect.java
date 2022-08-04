package com.luv2code.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

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
import com.luv2code.aopdemo.AroundWithLoggerDemoApp;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	private static Logger myLogger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());
	
	@Before("com.luv2code.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()") 
	public void beforeAddAccountAdvice(JoinPoint joinpoint) {
		myLogger.info("\n====>> Executing @Before advice on addAccount");
		
		// display the method signature
		MethodSignature signature = (MethodSignature) joinpoint.getSignature();
		// display the method arguments
		myLogger.info("Method: " + signature);
		
		// display method arguments
		
		// get args
		Object[] args = joinpoint.getArgs();
		
		// loop through args
		
		for (Object object : args) {
			myLogger.info(object.toString());
			
			if(object instanceof Account) {
				// downcast and print Account specific stuff
				Account account = (Account) object;
				
				myLogger.info("Account name: " + account.getName());
				myLogger.info("Account level: " + account.getLevel());
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
		myLogger.info("\n ====> Executing @AfterReturning on method " + method);
		
		// print results of method call
		
		myLogger.info("\n ====> result is... " + result);
		
		// lets post-process the data ... lets modify it
		
		// convert the accounts names to uppercase
		
		convertAccountNamesToUpperCase(result);
		
		myLogger.info("ACCOUNTS UPPERCASE: " + result);
		
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
		myLogger.info("\n====> Executing @AfterThrowing on method " + method);
		
		// log the expression
		myLogger.info("\n=====> The exception is: " + throwExc);
		
	}
	
	
	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().toShortString();
		myLogger.info("\n====> Executing @After (finally) on method " + method);
	}
	
	
	@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws  Throwable{
		
		// print out method we are advising on
		String method = proceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n====> Executing @Around on method " + method);
		
		// get begin timestamp
		long begin = System.currentTimeMillis();
		// execute the method
		
		Object result = proceedingJoinPoint.proceed(); 
		// get end timestamp
		
		long end = System.currentTimeMillis();
		
		// compute duration and display it
		
		long duration = end - begin;
		
		myLogger.info("\n======> Duration is " + duration / 1000.0 + " seconds");
		
		return result;
	}
	
	
}
