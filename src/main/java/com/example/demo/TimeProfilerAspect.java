package com.example.demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeProfilerAspect {

    public TimeProfilerAspect() {
        System.out.println("+++++++++");
    }

    
    @Around("execution(* com.example.demo.services.*.*(..))")
    public Object calculateTime(ProceedingJoinPoint pjp) throws Throwable {

        long start = System.currentTimeMillis();

        Object result = pjp.proceed(); // actual method runs

        long end = System.currentTimeMillis();

        System.out.println("total time = " + (end - start) + " ms");

        return result;
    }

    
    @Before("execution(* com.example.demo.services.*.*(..))")
    public void logger1() {
        System.out.println("adviced=========");
    }
}