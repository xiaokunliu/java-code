package com.dtrees.study.spring.web.servlet3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * Created by keithl on 2017/11/30.
 */
@Controller
public class AynscController {

    @Autowired
    private AynscService aynscService;

    @RequestMapping("/defer")
    @ResponseBody
    public DeferredResult<String> deferredResultCall(){
        return aynscService.getAynscUpdate();
    }

    // 在WebConfig中配置@EnableScheduling
}
