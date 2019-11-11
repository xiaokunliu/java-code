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
    public void doBeforeCriticism() {
        System.out.println("CriticismEngineImpl have not do any thing before Criticism");
    }

    @Override
    public void doAfterCriticism() {
        System.out.println("CriticismEngineImpl have done after Criticism");
    }
}
