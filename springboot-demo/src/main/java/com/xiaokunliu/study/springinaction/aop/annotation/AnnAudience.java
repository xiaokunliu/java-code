package com.xiaokunliu.study.springinaction.aop.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 使用注解定义一个切面类，包含定义通知以及切点，使用注解的切面声明必须能够为通知类添加注解，为此要做到这点，必须有源码
 * 使用原则，基于注解的配置优于Java的配置，基于Java的配置优于xml的配置
 * @Aspect 使用该注解，Spring会动态为该Bean以及对应的目标bean创建代理对象，通过代理对象来实现目标，也就是通知
 */
@Aspect
public class AnnAudience {

    private static final Logger LOGGER = LoggerFactory.getLogger(AnnAudience.class);

    @Pointcut("execution(* com.xiaokunliu.study.springinaction.aop.annotation.AnnPerformance.perform(..))")
    public void performance(){
        // 方法内容并不重要，只是作为注解的附体
    }

    @Before("performance()")
    public void silenceCellPhones(){
        System.out.println("silencing cell phones ... ");
    }

    @After("performance()")
    public void takeSeats(){
        System.out.println("taking seats ...");
    }

    @AfterReturning("performance()")
    public void applause(){
        System.out.println("applause ...");
    }

    @AfterThrowing("performance()")
    public void demandRefund(){
        System.out.println("demand refund ...");
    }

    @Around("performance()")
    public Object watchPerformance(ProceedingJoinPoint proceedingJoinPoint){
        try{
            LOGGER.info("silencing cell phones ....");
            LOGGER.info("taking seats ....");
            return proceedingJoinPoint.proceed();
        }catch (Throwable e){
            LOGGER.error("catching error from watchPerformance,messages=%s", e.getMessage());
            return null;
            //demandRefund();
        }finally {
            LOGGER.info("demand refund ..... ");
        }
    }

}
