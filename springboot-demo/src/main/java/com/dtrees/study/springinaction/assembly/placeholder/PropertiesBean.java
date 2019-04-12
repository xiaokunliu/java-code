package com.dtrees.study.springinaction.assembly.placeholder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by keithl on 2017/11/15.
 */
@Component
public class PropertiesBean implements Serializable{

    private String title;
    private int age;

    @Value("#{'1248237617@qq.com'}")
    private String email;

    private List<Songs> songs = new ArrayList<>();

    public PropertiesBean(){
        for (int i =0;i < 10;i ++){
            songs.add(new Songs("keithl0029",i+""));
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public PropertiesBean(@Value("${title}") String title, @Value("${age}") int age) {
        this.title = title;
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public List<Songs> getSongs() {
        return songs;
    }

    public void setSongs(List<Songs> songs) {
        this.songs = songs;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "PropertiesBean{" +
                "title='" + title + '\'' +
                ", age=" + age +
                '}';
    }
}
