package com.dtrees.spring.core.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class Audience {
    // 定义切面

    /**
     * Aspect面向切面编程
     * @After 通知方法会在目标方法返回或抛出异常后调用
       @AfterReturning 通知方法会在目标方法返回后调用
       @AfterThrowing 通知方法会在目标方法抛出异常后调用
       @Around 通知方法会将目标方法封装起来
       @Before 通知方法会在目标方法调用之前执行
     */
    @Before("execution(* com.dtrees.spring.core.aop.Performance.perform(..))")
    public void silenceCellPhones(){
        System.out.println("silencing cell phones ... ");
    }

    @Before("execution(* com.dtrees.spring.core.aop.Performance.perform(..))")
    public void takeSeats(){
        System.out.println("taking seats ...");
    }

    @AfterReturning("execution(* com.dtrees.spring.core.aop.Performance.perform(..))")
    public void applause(){
        System.out.println("applause ...");
    }

    @AfterThrowing("execution(* com.dtrees.spring.core.aop.Performance.perform(..))")
    public void demandRefund(){
        System.out.println("demand refund ...");
    }

    // 环绕通知是最为强大的通知类型。它能够让你所编写的逻辑将被通知的目标方法完全包装起来。实际上就像在一个通知方法中同时编写前置通知和后置通知
    @Pointcut("execution(* com.dtrees.spring.core.aop.Performance.perform(..))")
    public void perform(){
        System.out.println("performing ...");
    }

    @Around("perform()")
    public void watchPerformance(ProceedingJoinPoint proceedingJoinPoint){
        try{
            System.out.println("silencing cell phones ...");
            System.out.println("Taking seats ...");
            proceedingJoinPoint.proceed();
            System.out.println("clap clap clap ...");
        }catch (Throwable e){
            System.out.println("demanding a refund ...");
        }
    }
}
