package com.xiaokunliu.study.springinaction.aop.aspectj;


/**
 * project:java-code
 * file:AopPerformanceImpl
 * package:com.xiaokunliu.study.springinaction.aop.aspectj
 * date:2019/9/24 08:59
 * author:keithl
 */
public class AopPerformanceImpl implements AopPerformance {

    @Override
    public void performance() {
        System.out.println("call AopPerformanceImpl performance ... ");
    }
}
