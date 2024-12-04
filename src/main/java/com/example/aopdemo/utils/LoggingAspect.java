package com.example.aopdemo.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	@Before("execution(* com.example.aopdemo.services.MyService.performTask(..))")
	public void logBefore() {
		System.out.println("Before peforming task");
	}
	
	@After("execution(* com.example.aopdemo.services.MyService.performTask(..))")
	public void logAfter() {
		System.out.println("After performing task");
	}
	
	@AfterReturning(pointcut = "execution(* com.example.aopdemo.services.MyService.getData(..))", 
			returning="data")
	public void logAfterReturning(String data) {
		System.out.println("Method executed and returned "+data);
	}
	
	@AfterThrowing(pointcut = "execution(* com.example.aopdemo.services.MyService.throwException(..)", throwing="ex")
	public void logAfterThrowing(Exception ex) {
		System.out.println("Exception caught "+ex.getMessage());
	}
	
	@Around("execution(* com.example.aopdemo.services.MyService.performTask(..))")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		// Before
		System.out.println("Before execution");
		long startTime = System.currentTimeMillis();
		
		// Perform the action 
		Object result = joinPoint.proceed();
		
		//After
		long elapsedTime = System.currentTimeMillis() - startTime;
		System.out.println("Method executed in "+elapsedTime + " ms" );
		return result;
	}

}
