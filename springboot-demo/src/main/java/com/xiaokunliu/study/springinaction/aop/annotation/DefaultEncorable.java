package com.xiaokunliu.study.springinaction.aop.annotation;

/**
 * project:java-code
 * file:DefaultEncorable
 * package:com.xiaokunliu.study.springinaction.aop.annotation
 * date:2019/9/22 21:40
 * author:keithl
 */
public class DefaultEncorable implements Encorable {

    @Override
    public void perfermEncorable() {
        System.out.println("DefaultEncorable perfermEncorable ...");
    }
}
