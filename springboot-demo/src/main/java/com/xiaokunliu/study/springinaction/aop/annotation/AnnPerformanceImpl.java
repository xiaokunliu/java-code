package com.xiaokunliu.study.springinaction.aop.annotation;

import org.springframework.stereotype.Component;

/**
 * project:java-code
 * file:AnnPerformanceImpl
 * package:com.xiaokunliu.study.springinaction.aop.annotation
 * date:2019/9/24 11:29
 * author:keithl
 */
@Component
public class AnnPerformanceImpl implements AnnPerformance {

    @Override
    public void perform() {
        System.out.println("AnnPerformanceImpl performance ... ");
    }
}
