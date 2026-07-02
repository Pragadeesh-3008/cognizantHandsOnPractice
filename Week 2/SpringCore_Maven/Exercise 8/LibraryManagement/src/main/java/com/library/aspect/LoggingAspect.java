package com.library.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

    // Before Advice: Executed before any method in the service or repository packages
    @Before("execution(* com.library.service.*.*(..)) || execution(* com.library.repository.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("[AOP BEFORE] Entering method: " + joinPoint.getSignature().toShortString());
    }

    // After Advice: Executed after any method in the service or repository packages
    @After("execution(* com.library.service.*.*(..)) || execution(* com.library.repository.*.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("[AOP AFTER] Exiting method: " + joinPoint.getSignature().toShortString());
    }
}
