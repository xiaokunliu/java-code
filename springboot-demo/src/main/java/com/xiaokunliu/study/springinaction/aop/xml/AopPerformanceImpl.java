package com.xiaokunliu.study.springinaction.aop.xml;

/**
 * 定义切点  --  即要在哪里进行切面操作 where
 */
public class AopPerformanceImpl implements AopPerformance{

    @Override
    public void perform() {
        System.out.println("AnnPerformanceImpl performance ... ");
    }
}
