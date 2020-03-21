package com.xiaokunliu.interview.j2ee.ejb;

/**
 * project:java-code
 * file:RemoteServiceBean
 * package:com.xiaokunliu.j2ee.ejb
 * date:2019/9/2 11:14
 * author:keithl
 */
//@Stateless(mappedName="helloRemote")   // 表示无状态
public class RemoteServiceBean implements RemoteService {

    @Override
    public String callService(String message) {
        return String.format("from client message:%s", message);
    }
}
