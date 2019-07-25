package com.xiaokunliu.study.springboot_j2ee.spring.topic.aware;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by keithl on 2017/11/8.
 */
@Service
public class AwareService implements BeanNameAware,ResourceLoaderAware{

    private String beanName;
    private ResourceLoader resourceLoader;

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public void outputResult(){
        System.out.println(String.format("the bean name is %s",beanName));

        //load resource file
        Resource resource = resourceLoader.getResource("classpath:study/topic/topic.txt");

        try {
            System.out.println(String.format("load the file context is %s", IOUtils.toString(resource.getInputStream(),"UTF-8")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
