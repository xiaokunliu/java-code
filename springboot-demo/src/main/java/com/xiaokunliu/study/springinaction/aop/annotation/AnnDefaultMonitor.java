package com.xiaokunliu.study.springinaction.aop.annotation;

/**
 * project:java-code
 * file:DefaultEncorable
 * package:com.xiaokunliu.study.springinaction.aop.annotation
 * date:2019/9/22 21:40
 * author:keithl
 */
public class AnnDefaultMonitor implements AnnMonitor {

    @Override
    public void performMonitor() {
        // 处理监控的方法
        System.out.println("AnnDefaultMonitor performMonitor ... ");
    }
}
