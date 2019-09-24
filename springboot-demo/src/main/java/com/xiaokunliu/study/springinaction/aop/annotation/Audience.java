package com.xiaokunliu.study.springinaction.aop.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * 使用注解定义一个切面类，包含定义通知以及切点，使用注解的切面声明必须能够为通知类添加注解，为此要做到这点，必须有源码
 * 使用原则，基于注解的配置优于Java的配置，基于Java的配置优于xml的配置
 * @Aspect 使用该注解，Spring会动态为该Bean以及对应的目标bean创建代理对象，通过代理对象来实现目标，也就是通知
 */
@Aspect
public class Audience {

    // @xxx 通知 + com.xiaokunliu.study.springinaction.aop.Performance.perform 切点 完成目标
    // 方法是通知的动作，或者是通知的行为反应给项目工程

    /**
     *  类比场景：
     *      电力公司  --  项目
     *      抄表员需要登记住户的用电量并向公司汇报，抄表员的目标就是查询并记录用电量 -- 抄表员类似于切面的通知
     *      抄表员需要通过电表的机器来完成目标，也就是知道多少用电量是抄表员通过电表获取的详情  -- 电表类似于连接点，通过连接点能够向切面反应通知信息
     *      一个抄表员不可能所有地方都要去进行登记，必须是公司分配不同的区域让对应的抄表员负责跟进，也就是说每一个区域就是相当于【切点】，定义了在什么地方完成目标
     *      抄表员最后需要将每天在哪些地方用户的用电量记录下来进行汇总，那么这个就是切面
     *
     *      通知相当于抄表员的目标，也存在着对应业务要完成的目标，比如查询用户是否具有某项功能时，需要检查当前用户是否有权限查看，这个是否有权限就是目标
     *      连接点就相当于上述的电表（也就是电力公司提供的一个方便抄表员记录用电量的工具），反应到上述的程序就是权限检查的方法，这个就是连接点
     *      切点就是相当于上述的区域，反应到程序就是程序中就是有些需要进行权限查询，有些不需要，那么这些需要权限查询的地方就是切点
     *      切面就是上述的通知和切点的全部内容，就是定义在何处做何事
     *
     *      在代码实践过程中，需要将AOP应用到项目工程中，采用的手段可以是引入或者是织入方式
     *      引入就是在现有的类增加一个新的方法或者属性信息
     *      织入则需要将切面应用到目标对象中并创建新的代理对象来完成 -- Spring AOP是基于动态代理实现
     *
     *      Spring AOP仅支持方法级别的连接点，需要的时候可以通过Aspect方式来支持字段和构造器的连接点注入
     */

    // 定义切面 -- 通知Advice / 切点pointcut / 连接点join point

    /**
     * Aspect面向切面编程
     * @After 通知方法会在目标方法返回或抛出异常后调用 = AfterReturning + AfterReturning 的组合
       @AfterReturning 通知方法会在目标方法返回后调用
       @AfterThrowing 通知方法会在目标方法抛出异常后调用
       @Around 通知方法会将目标方法封装起来
       @Before 通知方法会在目标方法调用之前执行
     */
    @Before("execution(* com.xiaokunliu.study.springinaction.aop.annotation.Performance.perform(..))")
    public void silenceCellPhones(){
        System.out.println("silencing cell phones ... ");
    }

    @Before("execution(* com.xiaokunliu.study.springinaction.aop.annotation.Performance.perform(..))")
    public void takeSeats(){
        System.out.println("taking seats ...");
    }

    @AfterReturning("execution(* com.xiaokunliu.study.springinaction.aop.annotation.Performance.perform(..))")
    public void applause(){
        System.out.println("applause ...");
    }

    @AfterThrowing("execution(* com.xiaokunliu.study.springinaction.aop.annotation.Performance.perform(..))")
    public void demandRefund(){
        System.out.println("demand refund ...");
    }

    /**
     * 通过上述可知，execution(* com.xiaokunliu.study.springinaction.aop.Performance.perform(..)) 都是从重复使用，可以通过
     * @Pointcut 来频繁使用的切点表达式
     */
    // 创建环绕通知
    // 环绕通知是最为强大的通知类型。它能够让你所编写的逻辑将被通知的目标方法完全包装起来。实际上就像在一个通知方法中同时编写前置通知和后置通知
    @Pointcut("execution(* com.xiaokunliu.study.springinaction.aop.annotation.Performance.perform(..))")
    public void perform(){
        // 方法内容并不重要，只是作为注解的附体
    }

    @Around("perform()")
    public void watchPerformance(ProceedingJoinPoint proceedingJoinPoint){
        try{
            System.out.println("silencing cell phones ...");
            System.out.println("Taking seats ...");
            proceedingJoinPoint.proceed();
            System.out.println("clap clap clap ...");
        }catch (Throwable e){
            System.out.println("demanding a refund ...");
        }
    }


    // 注解引入新的功能 -- 使用AOP的引入功能，即切面能够为现有的对象方法增加额外的功能
    /**
     *                                          代理对象
     *             --- 现有的方法 ----        被通知的Bean对象
     * 调用者
     *             --- 被引入的方法 ----      引入的代理Bean对象
     *  当引入接口的方法被调用时，代理会把此调用委托给实现新接口的某个其他对象处理，即一个bean的实现被拆分到了多个类中
     */

    @DeclareParents(value = "com.xiaokunliu.study.springinaction.aop.annotation.Performance+",
                    defaultImpl = DefaultEncorable.class)
    private static Encorable encorable;
    /**
     * @DeclareParents
     *      value:指定哪种类型的bean要引入该接口，这里+表示所有实现Performance的子类型
     *      defaultImpl：引入新功能提供的实现类
     *      DeclareParents这个注解标注的静态属性指明要引入的接口
     */
}
