package com.xiaokunliu.study.springmvc_mybatis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * project:java-code
 * file:SpringmvcController
 * package:com.xiaokunliu.springmvc_mybatis.controller
 * date:2019/4/3 11:31 PM
 * author:keithl
 */
@Controller
@SessionAttributes("user")   // 将model中的属性名称为user的属性存放到HttpSession中
public class SpringmvcController {

    /**
     *  Model & ModelMap & @SessionAttributes & @ModelAttribute
     *  @ModelAttribute 修饰的方法会优先于getMapInfo方法的调用，该方法接收前台jsp页面传入的参数
     *  @ModelAttribute： 将请求的参数绑定到model对象，只支持一个属性且为String类型，表示绑定的属性名称
     */
    @ModelAttribute
    public void userModel(String username, String passsword, Model model){
        Map<String, Object> map = new HashMap<>();
        map.put("username", username);
        map.put("pwd", passsword);
        model.addAllAttributes(map);
    }

    @RequestMapping(value = "/gt1", method = RequestMethod.GET)
    public Map getMapInfo(Model model){
        Map<String,Object> map = model.asMap();
        return map;
    }

    @ModelAttribute
    public void userModelMap(@RequestParam(name = "name", required = true, defaultValue = "xxx", value = "aliasname") String username,
                             @RequestParam(name = "pwd", required = true, defaultValue = "xxxx", value = "aliasname") String passsword,
                             ModelMap modelMap){
        Map<String, Object> map = new HashMap<>();
        map.put("username", username);
        map.put("pwd", passsword);
        modelMap.addAllAttributes(map);
    }

    @RequestMapping("/gt2")
    public Map getModelMapInfo(ModelMap modelMap){
        Map<String,Object> map = modelMap;
        return map;
    }

    // @PathVariable  获取参数对应的userId
    @RequestMapping("/users/{userId}")
    public Map getUserInfo(@PathVariable Integer userId){
        return new HashMap();
    }

    // @RequestHeader 获取请求头数据
    @RequestMapping("/headers")
    public Map getHeaders(@RequestHeader("User-Agent") String userAgent,
                          @RequestHeader(value = "Accept") String[] accepts){
        return new HashMap();
    }

    // @CookieValue, 获取请求的cookie的数据
    @RequestMapping("/cookies")
    public Map getCookies(@CookieValue(value = "JSESSIONID", defaultValue = "")String sessionId){
        return new HashMap();
    }

    //
    @ModelAttribute
    public SpringUser userModel(@RequestParam(name = "name", required = true, defaultValue = "xxx", value = "aliasname") String username,
                                @RequestParam(name = "pwd", required = true, defaultValue = "xxxx", value = "aliasname") String passsword){
        SpringUser user = new SpringUser();
        user.setPaasowrd(passsword);
        user.setUserName(username);
        return user;
    }

    @RequestMapping("/getName")
    public String getName(@ModelAttribute("user")SpringUser user){
        return user.getUserName();
    }

}

class SpringUser implements Serializable{
    private String userName;
    private String paasowrd;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPaasowrd() {
        return paasowrd;
    }

    public void setPaasowrd(String paasowrd) {
        this.paasowrd = paasowrd;
    }
}
