package com.dtrees.activemq.test;

import com.dtrees.activemq.service.Publisher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * project:java-code
 * file:ActiveMqTest
 * package:com.dtrees.activemq.test
 * date:2018/10/5 上午10:14
 * author:keithl
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ActiveMqTopicTest {

    @Resource
    private Publisher publisher;

    @Test
    public void testTopic(){
        for (int i=0; i< 10; i++){
            publisher.sendMessage("test.topic", "send the message for i:"+i);
        }
    }

}
