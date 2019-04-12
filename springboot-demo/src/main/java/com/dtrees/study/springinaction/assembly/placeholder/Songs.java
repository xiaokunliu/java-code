package com.dtrees.study.springinaction.assembly.placeholder;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by keithl on 2017/11/15.
 */
@Component
public class Songs  implements Serializable{

    private String name;

    private String artist;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Songs(String name, String artist) {
        this.name = name;
        this.artist = artist;
    }

    public Songs(){}
}
