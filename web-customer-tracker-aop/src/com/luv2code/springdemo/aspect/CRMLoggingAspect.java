package com.luv2code.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	
	// setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	// setup pointcut declarations
	@Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
	public void forControllerPackage() {}
	
	// same for service and dao package
	
	@Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
	public void forServicePackage() {}
	
	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
	public void forDAOPackage() {}
	
	// match on only those packages
	@Pointcut("forControllerPackage() || forServicePackage() ||forDAOPackage()")
	private void forAppFlow() {}
	
	// add @Before advice
	
	@Before("forAppFlow()")
	public void before(JoinPoint joinPoint) {
		
		// display method we are calling
		String method = joinPoint.getSignature().toShortString();
		myLogger.info("======> in @Before: calling method: " + method);
		
		// display the arguments to the method
		
		// get the arguments 
		Object[] args = joinPoint.getArgs();
		
		// loop and display the arguments
		
		for (int i = 0; i < args.length; i++) {
			myLogger.info("=====> Arguments: " + args[i]);
		}
		
	}
	
	// add @AfterReturning advice
	@AfterReturning(
			pointcut = "forAppFlow()",
			returning = "result"
			)
	public void afterReturning(JoinPoint joinPoint, Object result) {
		
		String method = joinPoint.getSignature().toShortString();
		myLogger.info("======> in @AfterReturning: calling method: " + method);
		
		myLogger.info("=====> The result: " + result.toString());
		
	}
	
	
}
