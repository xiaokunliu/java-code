package com.dtrees.spring.core.bean;

import org.springframework.stereotype.Component;

/**
 * Created by keithl on 2017/10/17.
 */
@Component("peppersBean")   // peppersBean为当前bean指定id名称
public class SgtPeppers implements CompactDisc{

    private String title = "SgtPeppers title";
    private String artist = "The Beatles";

    @Override
    public void play() {
        System.out.println(String.format("playing %s by %s",title,artist));
    }

    /**
     * @Component:该类会作为组件类，并告知Spring要为这个类创建bean,前提是要启动扫描器
     * Spring应用上下文中所有的bean都会给定一个ID:将类名的第一个字母变为小写,即sgtPeppers
     * 自定义指定bean的Id:@Component(idName)
     * 也可以通过@Named注解来为bean设置ID,但是命名不好,不推荐使用
     */

    public void setTitle(String title){
        this.title = title;
    }
}
