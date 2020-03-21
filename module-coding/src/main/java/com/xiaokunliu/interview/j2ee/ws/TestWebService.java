package com.xiaokunliu.interview.j2ee.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;

/**
 * project:java-code
 * file:TestWebService
 * package:com.xiaokunliu.j2ee.ws
 * date:2019/10/2 17:58
 * author:keithl
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public class TestWebService {

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8888/testWS", new TestWebService());
    }

    @WebMethod
    public String sayHello(String msg) {
        return "Hello " + msg;
    }
}
