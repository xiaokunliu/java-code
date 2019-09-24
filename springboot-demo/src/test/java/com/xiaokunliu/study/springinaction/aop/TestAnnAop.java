package com.xiaokunliu.study.springinaction.aop;

import com.xiaokunliu.study.springinaction.aop.annotation.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * project:java-code
 * file:TestAnnAop
 * package:com.xiaokunliu.study.springinaction.aop
 * date:2019/9/24 11:25
 * author:keithl
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AnnConcertConfig.class)
public class TestAnnAop {

    @Autowired
    private AnnPerformance annPerformance;

    @Autowired
    private AnnMonitor monitor;

    @Autowired
    private AopCompactDisc aopCompactDisc;

    @Autowired
    private AopTrackCounter trackCounter;

    @Test
    public void testAnnAop(){
        System.out.println(annPerformance.getClass());
        System.out.println(monitor.getClass());
        System.out.println(monitor.getClass() == annPerformance.getClass());
    }

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
