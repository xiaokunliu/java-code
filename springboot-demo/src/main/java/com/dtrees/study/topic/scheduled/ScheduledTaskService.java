package com.dtrees.study.topic.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by keithl on 2017/11/8.
 */
@Service
public class ScheduledTaskService {

    private static final SimpleDateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Scheduled(fixedRate = 5000)    // 声明该方法为定时任务,fixedRate表示每隔5000ms执行一次,即5s执行一次
    public void reportCurrentTime(){
        System.out.println("execute the reportCurrentTime for every 5 seconds:"+FORMATTER.format(new Date()));
    }

    // 声明contron job,定时任务,根据定义的时间来做定时执行
    @Scheduled(cron = "0 45 13 ? * *")  // 每天的13点32分执行,是linux的下的cron定时任务
    public void fixTimeExecution(){
        System.out.println(String.format("在指定的时间内[%s]执行",FORMATTER.format(new Date())));
    }

}
