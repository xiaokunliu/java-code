package com.dtrees.spring.core.assembly;

import com.dtrees.spring.core.assembly.placeholder.SpELConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by keithl on 2017/11/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = EnvironmentConfig.class)
@ContextConfiguration(classes = SpELConfig.class)
public class PropertyHolderTest {

    @Autowired
    private SpELConfig spELConfig;

    @Test
    public void testBean(){
        System.out.println(spELConfig);
    }
}
