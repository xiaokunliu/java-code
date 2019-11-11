package com.xiaokunliu.study.springinaction.aop.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

/**
 * project:java-code
 * file:AnnEncorableAspect
 * package:com.xiaokunliu.study.springinaction.aop.annotation
 * date:2019/9/24 13:18
 * author:keithl
 */
@Aspect
public class AnnMonitorAspect {

    @DeclareParents(value = "com.xiaokunliu.study.springinaction.aop.annotation.AnnPerformance+", defaultImpl = AnnDefaultMonitor.class)
    private static AnnMonitor monitor;

}
