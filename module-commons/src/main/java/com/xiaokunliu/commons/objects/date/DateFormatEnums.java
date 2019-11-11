package com.xiaokunliu.commons.objects.date;

import java.text.SimpleDateFormat;

/**
 * Created by keithl on 2017/10/11.
 */

public enum DateFormatEnums {

    DATE_TIME_LINE_FORMAT("yyyy-MM-dd HH:mm:ss"), DATE_LINE_FORMAT("yyyy-MM-dd"),
    DATE_TIME_SLASH_FORMAT("yyyy/MM/dd HH:mm:ss"),DATE_SLASH_FORMAT("yyyy/MM/dd"),
    DATE_TIME_FOR_MONGO("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"), DATE_TIME_FORMAT("yyyyMMddHHmmss");

    private String formatString;

    DateFormatEnums(String formatString) {
        this.formatString = formatString;
    }

    public SimpleDateFormat getFormatInstance(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatString);
        return simpleDateFormat;
    }

    public String getFormatString(){
        return this.formatString;
    }
}
