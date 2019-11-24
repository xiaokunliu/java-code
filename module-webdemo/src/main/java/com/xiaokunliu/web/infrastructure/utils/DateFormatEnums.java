package com.xiaokunliu.web.infrastructure.utils;

import java.text.SimpleDateFormat;

/**
 * Created by xiaofeng on 2019/07/04.
 */

public enum DateFormatEnums {

    DATE_TIME_LINE_FORMAT("yyyy-MM-dd HH:mm:ss"), DATE_LINE_FORMAT("yyyy-MM-dd");

    private String formatString;

    DateFormatEnums(String formatString) {
        this.formatString = formatString;
    }

    public SimpleDateFormat getFormatInstance() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatString);
        return simpleDateFormat;
    }

    public String getFormatString() {
        return this.formatString;
    }
}
