package com.xiaokunliu.j2ee.ejb;

/**
 * project:java-code
 * file:RemoteService
 * package:com.xiaokunliu.j2ee.ejb
 * date:2019/9/2 11:12
 * author:keithl
 */
//@Local  EJB3注解，表示本地服务，这里没有引入
public interface LocalService {

    String callService(String message);
}
