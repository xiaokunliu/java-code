package com.xiaokunliu.study.springinaction.aop.xml;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * project:java-code
 * file:TrackCounter
 * package:com.xiaokunliu.study.springinaction.aop
 * date:2019/9/22 17:53
 * author:keithl
 */
//@Aspect
public class AopTrackCounter {

    /**
     * 处理通知中的参数
     * 目标： 需要记录每个磁道被播放的次数，此时需要将记录被播放的次数与播放本身分离出来
     */
    private Map<String, Integer> trackedCounters = new ConcurrentHashMap<>();

//    @Pointcut("execution(* com.xiaokunliu.study.springinaction.aop.xml.AopCompactDisc.play(java.lang.String)) && args(trackedNumber)")
    public void trackedPlay(String trackedNumber){}


//    @Before("trackedPlay(trackedNumber)")
    public void countTracked(String trackedNumber){
        int counter = getCountTrack(trackedNumber);
        trackedCounters.put(trackedNumber, counter + 1);
    }

    public int getCountTrack(String trackerNumber){
        // 1.8 版本 Map.getOrDefault
        return trackedCounters.getOrDefault(trackerNumber, 0);
    }
}
