package com.densoft.springcrm.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.net.JarURLConnection;
import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {
    //setup logger
    private Logger myLogger = Logger.getLogger(getClass().getName());
    //set up pointcut declarations

    @Pointcut("execution(* com.densoft.springcrm.controllers.*.*(..))")
    private void forControllerPackage() {

    }

    @Pointcut("execution(* com.densoft.springcrm.DAO.*.*(..))")
    private void forDaoPackage() {

    }

    @Pointcut("execution(* com.densoft.springcrm.service.*.*(..))")
    private void forServicePackage() {

    }

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow() {

    }

    //add @Before advice
    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint) {
        //display method we are calling
        String method = joinPoint.getSignature().toShortString();
        myLogger.info("======> in @Before: calling method: " + method);
        //display the arguments to the method

        Object[] args = joinPoint.getArgs();

        for (Object arg : args) {
            myLogger.info("====>> argument: " + arg);
        }

    }

    //add @AfterReturning advice
    @AfterReturning(pointcut = "forAppFlow()", returning = "theResult")
    public void afterReturning(JoinPoint joinPoint, Object theResult) {
//display method we are calling
        String method = joinPoint.getSignature().toShortString();
        myLogger.info("======> in @AfterReturning: from method: " + method);
        //display the arguments to the method
        myLogger.info("====> result: " + theResult);
    }
}
