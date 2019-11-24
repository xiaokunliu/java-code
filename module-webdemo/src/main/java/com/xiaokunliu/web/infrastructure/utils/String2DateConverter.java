package com.xiaokunliu.web.infrastructure.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.util.Date;

public class String2DateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String source) {
        if (StringUtils.isBlank(source)) {
            return null;
        }
        source = source.trim();
        try {
            if (source.contains(":")) {
                return DateUtility.parseWithDateTimeLine(source);
            }
            return DateUtility.parseWithDateLine(source);
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
    }
}
