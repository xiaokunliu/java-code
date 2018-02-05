package com.dtrees.study.spring.web.sse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;


/**
 * Created by keithl on 2017/11/30.
 */
@Controller
public class SSEController {

    @RequestMapping(value = "/push",produces = "text/event-stream")
    public @ResponseBody String push(){
        Random random = new Random();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "data:Testing 1,2,3,"+random.nextInt()+"\n\n";
    }
}
