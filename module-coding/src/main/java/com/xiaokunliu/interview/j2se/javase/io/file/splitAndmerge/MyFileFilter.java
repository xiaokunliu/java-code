package com.xiaokunliu.interview.j2se.javase.io.file.splitAndmerge;

import java.io.File;
import java.io.FilenameFilter;

public class MyFileFilter implements FilenameFilter {

    private String stuffix;


    public MyFileFilter(String stuffix) {
        super();
        this.stuffix = stuffix;
    }


    @Override
    public boolean accept(File dir, String name) {
        // TODO Auto-generated method stub
        return name.endsWith(stuffix);
    }

}
