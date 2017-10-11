package com.dtrees.springmvc.web;

import com.dtrees.springmvc.web.home.Spittle;
import com.dtrees.springmvc.web.home.SpittleRespository;
import com.dtrees.springmvc.web.home.WebFormModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by keithl on 2017/9/28.
 */
@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private SpittleRespository spittleRespository;

    public HomeController(){}


    @RequestMapping(method = RequestMethod.GET)
    public String index(){
        return "home";
    }

    /**
     * 返回视图名称
     * @param model
     * @return
     */
    @RequestMapping(value = "/spittles",method = RequestMethod.GET)
    public String spittles(Model model){
        model.addAttribute("spittlesList",spittleRespository.findSpittles(Long.MAX_VALUE,20));
        return "spittles";
//        DispatcherServlet
    }

    /**
     *  没有返回视图名称,也没有显式地设定模型,此时处理器会将值放到模型中,模型的key会根据其类型推断出,key是spittlesList,即名称+类型
     *  而逻辑视图名称将会根据请求路径得出,即/spittles的视图名称将会是spittles
     * @return
     */
    @RequestMapping(value = "/spittles",method = RequestMethod.GET)
    public List<Spittle> spittlesForAnother(){
        return spittleRespository.findSpittles(Long.MAX_VALUE,20);
    }

    // =============================接受请求的输入===================================
    /**
     * 客户端中的数据传送到控制器的处理器方法中
     *  查询参数(Query Parameter)
     *  表单参数(Form Parameter)
     *  路径变量(Path Variable)
     */

    // 查询参数
    @RequestMapping(value = "/spittles",method = RequestMethod.GET)
    public List<Spittle> spittlesWithParameter(@RequestParam(value = "max",defaultValue = Long.MAX_VALUE + "") long max,
                                               @RequestParam(value = "count",defaultValue = "20") int counter){
        System.out.println(String.format("the max[%d],and the counter[%d]",max,counter));
        return spittleRespository.findSpittles(Long.MAX_VALUE,20);
    }

    // 路径查询
    @RequestMapping(value = "/spittles",method = RequestMethod.GET)
    public List<Spittle> spittlesWithPath(@PathVariable long spittleId,Model model){
        System.out.println(String.format("the spittleId[%d],and the model[%d]",spittleId,model.toString()));
        return spittleRespository.findSpittles(Long.MAX_VALUE,20);
    }

    // form 表单查询
    /**
     * 必须完成注册表单
     * @param model
     * @return
     */
    @RequestMapping(value = "/processing",method = RequestMethod.POST)
    public String processingRequest(@Valid WebFormModel model){
        return "redirect:/home/processing/" + model.getUsername();
    }

// ==============================================渲染Web视图=======================================================
//    ViewResolver
//      BeanNameViewResolver:将视图解析为Spring应用上下文中的bean，其中bean的ID与视图的名字相同
//      ContentNegotiatingViewResolver:通过考虑客户端需要的内容类型来解析视图，委托给另外一个能够产生对应内容类型的视图解析器
//      FreeMarkerViewResolver:将视图解析为FreeMarker模板
//      InternalResourceViewResolver:将视图解析为Web应用的内部资源(一般为JSP)
//      JasperReportsViewResolver:将视图解析为JasperReports定义
//      ResourceBundleViewResolver:将视图解析为资源bundle(一般为属性文件)
//      TilesViewResolver:将视图解析为Apache Tile定义，其中tile ID与视图名称相同。注意有两个不同 的TilesViewResolver实现，分别对应于Tiles 2.0和Tiles 3.0
//      UrlBasedViewResolver:直接根据视图的名称解析视图,视图的名称会匹配一个屋里视图的定义
//      VelocityLayoutViewResolver:将视图解析为Velocity布局，从不同的Velocity模板中组合页面
//      VelocityViewResolver:将视图解析为Velocity模板
//      XmlViewResolver:将视图解析为特定XML文件中的bean定义。类似于BeanName-ViewResolver
//      XsltViewResolver:将视图解析为XSLT转换后的结果


//    InternalResourceViewResolver:将视图解析为Web应用的内部资源(一般为JSP)
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String showSpringJspTag(Model model){
        model.addAttribute(new WebFormModel());
        return "springjsp";
    }



//    BeanNameViewResolver:将视图解析为Spring应用上下文中的bean，其中bean的ID与视图的名字相同
//    FreeMarkerViewResolver:将视图解析为FreeMarker模板
//    VelocityViewResolver:将视图解析为Velocity模板
//    TilesViewResolver:将视图解析为Apache Tile定义
//     Thymeleaf是一种用来替代JSP的 新兴技术，Spring提供了与Thymeleaf的原生模板(natural template)协作的视图解析器
}
