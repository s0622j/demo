package com.example.demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    @Before("execution(* com.example.demo.HpPrinter.*(..))")
    public void before() {
        System.out.println("I'm before");
    }
}

//@Aspect
//@Component
//public class MyAspect {
//
//    @After("execution(* com.example.demo.HpPrinter.*(..))")
//    public void after() {
//        System.out.println("I'm after");
//    }
//}

//@Aspect
//@Component
//public class MyAspect {
//
//    @Around("execution(* com.example.demo.HpPrinter.*(..))")
//    public Object around(ProceedingJoinPoint pjp) throws Throwable {
//        System.out.println("I'm around before");
//
//        // 執行切入點的方法，obj 為切入點方法執行的結果
//        Object obj = pjp.proceed();
//
//        System.out.println("I'm around after");
//        return obj;
//    }
//}