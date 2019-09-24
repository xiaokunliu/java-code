package com.xiaokunliu.study.springinaction.aop;

import com.xiaokunliu.study.springinaction.aop.annotation.AopCompactDisc;
import com.xiaokunliu.study.springinaction.aop.annotation.AopCompactDiscConfig;
import com.xiaokunliu.study.springinaction.aop.annotation.AopTrackCounter;
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
@ContextConfiguration(classes = AopCompactDiscConfig.class)
public class TestAspectAop {

    @Autowired
//    @Qualifier("aopCompactDisc")
    private AopCompactDisc aopCompactDisc;

    @Autowired
    private AopTrackCounter trackCounter;

    @Test
    public void testTrackCounter(){
        System.out.println(aopCompactDisc.getClass());
        String trackNumber = "trackingNumber";
        aopCompactDisc.play(trackNumber);
        System.out.println(trackCounter.getCountTrack(trackNumber));

        aopCompactDisc.play(trackNumber);
        System.out.println(trackCounter.getCountTrack(trackNumber));

        aopCompactDisc.play(trackNumber);
        System.out.println(trackCounter.getCountTrack(trackNumber));

        aopCompactDisc.play(trackNumber);
        System.out.println(trackCounter.getCountTrack(trackNumber));

        aopCompactDisc.play(trackNumber);
        System.out.println(trackCounter.getCountTrack(trackNumber));

        aopCompactDisc.play(trackNumber);
        System.out.println(trackCounter.getCountTrack(trackNumber));

        aopCompactDisc.play(trackNumber);
        System.out.println(trackCounter.getCountTrack(trackNumber));

        aopCompactDisc.play(trackNumber);
        System.out.println(trackCounter.getCountTrack(trackNumber));
    }
}
