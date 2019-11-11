package com.xiaokunliu.study.springboot_j2ee.spring.config.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by keithl on 2017/11/8.
 */
@Service
public class FnService {

    @Autowired
    private FnDao fnDao;

    public void service(){
        fnDao.doFnDao();
    }
}
