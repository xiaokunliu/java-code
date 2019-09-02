package com.xiaokunliu.j2ee.ejb;

/**
 * project:java-code
 * file:RemoteService
 * package:com.xiaokunliu.j2ee.ejb
 * date:2019/9/2 11:12
 * author:keithl
 */
//@Stateless(mappedName="helloLocal")  EJB3注解，表示本地服务，这里没有引入
public class LocalServiceBean implements LocalService{

    public String callService(String message){
        return String.format("local service bean message:%s", message);
    }
}
