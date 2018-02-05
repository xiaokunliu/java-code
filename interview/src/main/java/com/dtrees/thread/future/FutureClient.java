package com.dtrees.thread.future;

/**
 * Created by keithl on 2017/11/14.
 */

public class FutureClient {

    public FutureData getResponseText(final String queryString){
        final FutureData futureData = new FutureData();
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 发送请求,实际请求是委托FutureData去执行
                System.out.println("FutureData 发送请求...");
                futureData.setRequest(queryString);
                System.out.println("FutureData 获取请求结果...");
            }
        }).start();
        return futureData;
    }
}
