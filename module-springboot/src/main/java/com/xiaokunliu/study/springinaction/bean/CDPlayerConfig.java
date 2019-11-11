package com.xiaokunliu.study.springinaction.bean;

import org.springframework.context.annotation.*;

/**
 * Created by keithl on 2017/10/17.
 */

@Configuration
@ComponentScan(basePackageClasses = {CompactDisc.class})
@Import(CDConfig.class)
@ImportResource({"classpath:spring/beans.xml"})
public class CDPlayerConfig {

    /**
     * @ComponentScan:注解能够在Spring中启用组件扫描,默认会扫描与配置类相同的包,即会扫描这个包以及这个包下的所有子包,查找带有@Component注解的类
     * 为何设置基础包:有一个原因会促使我们明确地设置基础包，那就是我们想要将配置类放在单独的包中，使其与其他的应用代码区分开
     * 使用String设置组件扫描的基础包:
     *      单个:basePackages = "com.xiaokunliu.ssm.core.bean"
     *      多个:basePackages = {"com.xiaokunliu.ssm.core.bean","com.xiaokunliu.ssm.bean2",...}
     * 使用Class来设置组件扫描的基础包(推荐):
     *      basePackageClasses = {},basePackageClasses属性所设置的数组中包含了类,这些类所在的包将会作为组件扫描的基础包
     * @Import({}):将多个配置类进行组合一起
     * @ImportResource("classpath:beans.xml"):将spring配置的xml组合在一起
     */

    // 声明简单的bean并指定bean的id名称
//    @Bean(name = "sgtPeppers")
//    public CompactDisc getCompactDisc(){
//        return new SgtPeppers();
//    }

    @Bean(name = "cdPlayer")
    public MediaPlayer getMediaPlayer(CompactDisc compactDisc){
        return new CDPlayer(compactDisc);
    }

    //另一种方式注入
//    @Bean(name = "cdPlayer")
//    public MediaPlayer getMediaPlayer(CompactDisc compactDisc){
//        return new CDPlayer(compactDisc);
//    }

    // 可以借助Spring Tool Suite创建配置文件,

//    CDPlayerConfig中使用@Import注解导入CDConfig

    // 装配bean的三种方式
//    自动化配置、基于Java的显式配置 以及基于XML的显式配置
}
