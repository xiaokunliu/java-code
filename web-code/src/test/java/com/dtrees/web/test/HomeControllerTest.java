package com.dtrees.web.test;

import com.dtrees.springmvc.web.HomeController;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceView;

/**
 * Created by keithl on 2017/9/28.
 */

public class HomeControllerTest {

    @Test
    public void testIndex() throws Exception{
        HomeController homeController = new HomeController();
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(homeController)
                                          .setSingleView(new InternalResourceView("/WEB-INF/views/home.jsp"))
                                          .build();
        mockMvc.perform(MockMvcRequestBuilders.get("/home")).andExpect(MockMvcResultMatchers.view().name("home"));
    }
}
