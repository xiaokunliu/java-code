package com.dtrees.study.springinaction.bean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

/**
 * Created by keithl on 2017/10/17.
 * Spring 测试代码
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
public class CDPlayerTest {

    /**
     * SpringJUnit4ClassRunner:在测试开始的时候自动创建Spring的应用上下文
     * 注解@ContextConfiguration:告诉它需要在CDPlayerConfig中加载配置
     */

    /**
     * @Autowired:自动装配依赖的bean,即Spring自动满足bean依赖的一种方法，在满足依赖的过程中，会在 Spring应用上下文中寻找匹配某个bean需求的其他bean
     * 如果没有匹配的bean，那么在应用上下文创建的时候，Spring会抛出一个异常。为了避免异常的出现，你可以将@Autowired的required属性设置为false
     * 如果有多个bean都能满足依赖关系的话，Spring将会抛出一个异常，表明没有明确指定要选择哪 个bean进行自动装配
     */

    @Autowired
    private CompactDisc compactDisc;

    @Autowired
    private MediaPlayer cdPlayer;

    @Test
    public void testCompactDiscNotNull(){
        assertNotNull(compactDisc);
    }

    @Test
    public void testCDNotNull(){
        assertNotNull(cdPlayer);
        assertNotNull(cdPlayer.getCompactDisc());
    }
}
