package com.dtrees.study.springboot_j2ee.spring.web.servlet3;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * Created by keithl on 2017/11/30.
 */
@Service
public class AynscService {

    private DeferredResult<String> deferredResult;

    public DeferredResult<String> getAynscUpdate(){
        deferredResult = new DeferredResult<>();
        return deferredResult;  // 产生结果数据给控制器使用
    }

    // 定时更新deferredResult
    @Scheduled(fixedDelay = 5000)
    public void refresh(){
        if (deferredResult != null){
            deferredResult.setResult(new Long(System.currentTimeMillis()).toString());
        }
    }
}
