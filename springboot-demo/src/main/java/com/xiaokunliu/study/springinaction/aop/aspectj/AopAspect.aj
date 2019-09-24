package com.xiaokunliu.study.springinaction.aop.aspectj;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 创建Aspect面向切面
 */
public aspect AopAspect {
    private final Logger LOG = LoggerFactory.getLogger(AopAspect.aspectOf().toString());

    private CriticismEngine criticismEngine;

    public void setCriticismEngine(CriticismEngine criticismEngine) {
        this.criticismEngine = criticismEngine;
    }

    public AopAspect(){}

    pointcut performance(): execution(* AopPerformance.performance(..));

    before(): performance() {
        System.out.println("before performance ...");
        criticismEngine.getCriticism();
    }

    after(): performance() {
        criticismEngine.getCriticism();
        System.out.println("after performance ... ");
    }

    around(): performance() {
        try{
            System.out.println("before performance ...");
            criticismEngine.getCriticism();
            System.out.println("after performance ... ");
        }catch (Exception e){
            LOG.error(e.getMessage(), e);
            System.out.println("throwing the performance ...");
        }
    }
}
