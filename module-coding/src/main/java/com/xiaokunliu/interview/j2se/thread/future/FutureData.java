package com.xiaokunliu.interview.j2se.thread.future;

/**
 * Created by keithl on 2017/11/14.
 */

public class FutureData implements Data {

    private boolean isCompleted;
    private RealData realData = new RealData();

    @Override
    public synchronized String getResult() {
        while (!isCompleted) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return this.realData.getResult();
    }

    public synchronized void setRequest(String queryString) {
        if (isCompleted) return;
        this.realData.setResult(queryString);
        isCompleted = true;
        notify();
    }
}
