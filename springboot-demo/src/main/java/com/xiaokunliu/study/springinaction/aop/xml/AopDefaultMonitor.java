package com.xiaokunliu.study.springinaction.aop.xml;

/**
 * project:java-code
 * file:DefaultEncorable
 * package:com.xiaokunliu.study.springinaction.aop.annotation
 * date:2019/9/22 21:40
 * author:keithl
 */
public class AopDefaultMonitor implements AopMonitor {

    @Override
    public void perfermEncorable() {
        System.out.println("DefaultEncorable perfermEncorable ...");
    }
}
