package com.xiaokunliu.interview.j2ee.ejb;

/**
 * project:java-code
 * file:RemoteService
 * package:com.xiaokunliu.j2ee.ejb
 * date:2019/9/2 11:12
 * author:keithl
 */
//@Remote   EJB3注解，表示远程服务，这里没有引入
public interface RemoteService {

    String callService(String message);
}
