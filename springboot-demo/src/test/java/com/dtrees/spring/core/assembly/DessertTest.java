package com.dtrees.spring.core.assembly;

import com.dtrees.spring.core.assembly.identifier.Cake;
import com.dtrees.spring.core.assembly.identifier.Dessert;
import com.dtrees.spring.core.assembly.identifier.IdentifierBeanConfig;
import com.dtrees.spring.core.assembly.identifier.Sweet;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by keithl on 2017/11/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = IdentifierBeanConfig.class)
public class DessertTest {

    @Autowired
    @Sweet
    private Dessert dessert;

    /**
     * 这时候spring定位到有两个bean有相同的修饰符就会出错
     * NoUniqueBeanDefinitionException:
     * No qualifying bean of type 'com.dtrees.spring.core.assembly.identifier.Dessert' available: expected single matching bean but found 2: cake,cookie
     */
    @Test
    public void testDessert(){
        Assert.assertNotNull(dessert);
        System.out.println(dessert.getClass() == Cake.class);;
    }
}
