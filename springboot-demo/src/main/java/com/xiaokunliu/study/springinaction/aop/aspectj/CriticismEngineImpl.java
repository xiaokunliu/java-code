package com.xiaokunliu.study.springinaction.aop.aspectj;

/**
 * project:java-code
 * file:CriticismEngineImpl
 * package:com.xiaokunliu.study.springinaction.aop.aspectj
 * date:2019/9/23 00:12
 * author:keithl
 */
public class CriticismEngineImpl implements CriticismEngine {

    @Override
    public String getCriticism() {
        return this.getClass().getName();
    }
}
