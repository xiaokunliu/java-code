package com.xiaokunliu.study.test.web;

import com.xiaokunliu.study.springboot_j2ee.spring.web.WebConfig;
import com.xiaokunliu.study.springboot_j2ee.spring.web.test.DemoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by keithl on 2017/11/30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfig.class})
@WebAppConfiguration("src/main/resources")      // 指定web的资源位置
public class TestController {

    private MockMvc mockMvc;    // 模拟web mvc对象

    @Autowired
    private DemoService demoService;    // 注入Spring的bean

    @Autowired
    private WebApplicationContext context;// 注入WebApplicationContext

    @Autowired
    private MockHttpSession mockHttpSession;    // 可以注入session

    @Autowired
    private MockHttpServletRequest request;     // 可以注入request

    @Before
    public void setUp(){
        // 创建模拟mvc对象
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }

    @Test
    public void testNormalController() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/normal"))                  // 模拟向/normal进行get请求
                .andExpect(MockMvcResultMatchers.status().isOk())               // 预期控制状态返回200
                .andExpect(MockMvcResultMatchers.view().name("page"))           // 预期view的名称为page
                .andExpect(MockMvcResultMatchers.forwardedUrl("/WEB-INF/classes/views/page.jsp"))   // 预期页面转向的真正路径是/WEB-INF/classes/views/page.jsp
                .andExpect(MockMvcResultMatchers.model().attribute("message",demoService.saySomething()));  // 预期model的值返回hello
    }


    @Test
    public void testRestController() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/testRest"))        // 模拟向/testRest进行get请求
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=UTF-8"))     // 预期返回的媒体类型是text/plain;charset=UTF-8
                .andExpect(MockMvcResultMatchers.content().string(demoService.saySomething()));         // 预期返回的内容为service输出的hello值
    }
}
