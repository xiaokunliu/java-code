package com.xiaokunliu.interview.j2se.javase.io.file;

import java.io.File;
import java.io.FileFilter;

public class MyFileFilter implements FileFilter {

    /*
     * 自定义文件过滤器
     */
    private String suffix;

    public MyFileFilter(String suffix) {
        this.suffix = suffix;
    }

    @Override
    public boolean accept(File pathname) {

        return pathname.getName().endsWith(suffix);
    }

}
