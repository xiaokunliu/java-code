package com.xiaokunliu.study.springinaction.aop.aspectj;


/**
 * 创建Aspect面向切面
 * TODO
 */
public aspect AopAspect {

    private CriticismEngine criticismEngine;

    public void setCriticismEngine(CriticismEngine criticismEngine) {
        this.criticismEngine = criticismEngine;
    }

    public AopAspect(){}

    pointcut performance(): execution(* AopPerformance.performance(..));

    before(): performance() {
        System.out.println("before performance ...");
        criticismEngine.doBeforeCriticism();
    }

    after(): performance() {
        System.out.println("after performance ... ");
        criticismEngine.doAfterCriticism();
    }

//    around(): performance() {
//        try{
//            System.out.println("before performance ...");
//            criticismEngine.doBeforeCriticism();
//
//            System.out.println("after performance ... ");
//            criticismEngine.doAfterCriticism();
//        }catch (Exception e){
//            LOG.error(e.getMessage(), e);
//            System.out.println("throwing the performance ...");
//        }
//    }
}
