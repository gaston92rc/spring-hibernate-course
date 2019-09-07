package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.net.UnknownHostException;
import java.time.LocalTime;

@Aspect
@Component
public class MyDemoLoggingAspect {

//    @Before("execution(public void add*())")
    @Before("execution(* com.luv2code.aopdemo.dao.*.*())")
    public void beforeAddAccountAdvice() {
        System.out.println("\nHello " + System.getProperty("user.name").toUpperCase() + " it's "+LocalTime.now());
        System.out.println("=======>>> Executing @Before advice on method");
    }

}
