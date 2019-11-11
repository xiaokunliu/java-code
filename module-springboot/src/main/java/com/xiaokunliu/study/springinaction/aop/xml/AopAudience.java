package com.xiaokunliu.study.springinaction.aop.xml;

import org.aspectj.lang.ProceedingJoinPoint;

public class AopAudience {

    public void silenceCellPhones(){
        System.out.println("silencing cell phones ... ");
    }

    public void takeSeats(){
        System.out.println("taking seats ...");
    }

    public void applause(){
        System.out.println("applause ...");
    }

    public void demandRefund(){
        System.out.println("demand refund ...");
    }

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
