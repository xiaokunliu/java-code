package com.xiaokunliu.common.objects.beans.converter;

import com.xiaokunliu.common.objects.date.DateUtility;
import org.apache.commons.beanutils.converters.DateTimeConverter;

import java.util.Calendar;
import java.util.Date;

public class DateTime2StringConvert extends DateTimeConverter{

    @Override
    protected Class<?> getDefaultType() {
        //将时间转换为字符串类型
        return String.class;
    }

    @Override
    protected String convertToString(Object value) throws Throwable {
        Date date = null;
        if (value instanceof Date) {
            date = (Date)value;
        } else if (value instanceof Calendar) {
            date = ((Calendar)value).getTime();
        } else if (value instanceof Long) {
            date = new Date(((Long)value).longValue());
        }
        return DateUtility.formatWithDateTimeLine(date);
    }

}
