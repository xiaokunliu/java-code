package com.dtrees.study.test;

import com.dtrees.study.core.profiles.ProfileBean;
import com.dtrees.study.core.profiles.ProfileConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * Created by keithl on 2017/11/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(ProfileConfig.PRODUCTION_ENV)
@ContextConfiguration(classes = {ProfileConfig.class})
public class SpringTest {

    @Autowired
    private ProfileBean profileBean;

    @Test
    public void profileBeanInject(){
        Assert.assertNotNull(profileBean);
        System.out.println(profileBean.getContext());
    }
}
