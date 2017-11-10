package com.dtrees.study.config.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by keithl on 2017/11/8.
 * 编写切面
 */
@Aspect     // 声明一个切面
@Component  // 让此切面作为Spring容器管理的Bean
public class LogAspect {

    // 注解声明切点
    @Pointcut("@annotation(com.dtrees.study.config.aop.Action)")
    public void annotationPointCut(){}

    // 声明一个advice,并使用@Pointcut声明切点
    @After("annotationPointCut()")
    public void after(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        Action action = method.getAnnotation(Action.class);
        System.out.println("注解式拦截之后:"+action.name()); // 通过反射获取注解上的名称
    }

    /**
     * execution(* com.sample.service.impl..*.*(..))
     解释如下：
     符号	                            含义
     execution（）                  表达式的主体；
     第一个”*“符号                   表示返回值的类型任意；
     com.sample.service.impl	    AOP所切的服务的包名，即，我们的业务部分
     包名后面的”..“	                表示当前包及子包
     第二个”*“	                    表示类名，*即所有类。此处可以自定义，下文有举例
     .*(..)	                        表示任何方法名，括号表示参数，两个点表示任何参数类型
     */

    @Before("execution(* com.dtrees.study.config.aop.AopService.*(..))")
    public void before(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("方式execution拦截之前:"+method.getName()); // 通过反射获取注解上的名称
    }

}
