package com.dtrees.activemq.test;

import com.dtrees.activemq.service.Consumer;
import com.dtrees.activemq.service.Producer;
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
public class ActiveMqQueueTest {

    @Resource
    private Producer producer;

    @Resource
    private Consumer consumer;

    @Test
    public void testProducer(){
        for (int i=0; i< 10; i++){
            producer.sendMessage("test.queue", "send the message for i:"+i);
        }
    }

}
