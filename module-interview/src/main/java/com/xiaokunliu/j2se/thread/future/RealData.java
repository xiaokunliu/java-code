package com.xiaokunliu.j2se.thread.future;

import java.util.concurrent.TimeUnit;

/**
 * Created by keithl on 2017/11/14.
 */

public class RealData implements Data {

    private String result;

    @Override
    public String getResult() {
        return this.result;
    }

    public void setResult(String queryString) {
        System.out.println(String.format("获取到客户端的请求[%s]", queryString));

        // 开始查询
        System.out.println("开始查询,需要耗时5s....");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.result = "获取到用户列表userlist";
        return;
    }
}
