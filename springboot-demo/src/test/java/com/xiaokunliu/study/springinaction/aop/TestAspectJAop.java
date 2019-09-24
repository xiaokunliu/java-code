package com.xiaokunliu.study.springinaction.aop;

import com.xiaokunliu.study.springinaction.aop.aspectj.AopAspect;
import com.xiaokunliu.study.springinaction.aop.aspectj.AspectJConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * project:java-code
 * file:TestAspectAop
 * package:com.xiaokunliu.study.springinaction.aop
 * date:2019/9/22 18:10
 * author:keithl
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AspectJConfig.class)
public class TestAspectJAop {

//    @Autowired
//    private AopAspect aopAspect;

    @Test
    public void testTrackCounter(){

    }
}
