package com.xiaokunliu.study.config.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by keithl on 2017/11/8.
 */
@Controller
public class FnController {

    @Autowired
    private FnService fnService;

    public void execute(){
        fnService.service();
    }
}
