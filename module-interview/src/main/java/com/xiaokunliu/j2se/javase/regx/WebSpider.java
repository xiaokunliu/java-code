package com.xiaokunliu.j2se.javase.regx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 网页爬虫
 * 获取一个网页的邮箱地址
 */
public class WebSpider {

    public static void main(String[] args) throws IOException {

        /*
         * 能上网再测试
         */
        String urlPath = "http://www.baidu.com";
        List<String> mails = getAllEmails(urlPath);

    }

    public static List<String> getAllEmails(String urlPath) throws IOException {

        URL url = new URL(urlPath);

        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
//		//使用正则表达式获取邮箱
//		构建正则表达式
        String regex = "\\w+@\\w+(\\.\\w+)+";
        Pattern pattern = Pattern.compile(regex);

        List<String> mails = new ArrayList<String>();
//		System.out.println("1248237617@qq.com.cn".matches(regex));
        String line = null;
        while ((line = br.readLine()) != null) {
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                mails.add(matcher.group());
            }
        }
        return mails;
    }


}
