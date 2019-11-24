package com.xiaokunliu.web.infrastructure.utils;

import java.text.ParseException;
import java.util.Date;

/**
 * Created by xiaofeng on 2019/07/04.
 */

public final class DateUtility {

    private DateUtility() {
    }

    /**
     * @param date
     * @return 返回示例:2017-10-08 23:39:00
     */
    public static String formatWithDateTimeLine(Date date) {
        return DateFormatEnums.DATE_TIME_LINE_FORMAT.getFormatInstance().format(date);
    }

    /**
     * @param date
     * @return 返回示例:2017-10-08
     */
    public static String formatWithDateLine(Date date) {
        return DateFormatEnums.DATE_LINE_FORMAT.getFormatInstance().format(date);
    }


    /**
     * @param dateTimeLineString,输入必须是类似于:2017-10-08 23:39:00
     * @return
     * @throws ParseException
     */
    public static Date parseWithDateTimeLine(String dateTimeLineString) throws ParseException {
        return DateFormatEnums.DATE_TIME_LINE_FORMAT.getFormatInstance().parse(dateTimeLineString);
    }

    /**
     * @param dateLineString,输入必须是类似于:2017-10-08
     * @return
     * @throws ParseException
     */
    public static Date parseWithDateLine(String dateLineString) throws ParseException {
        return DateFormatEnums.DATE_LINE_FORMAT.getFormatInstance().parse(dateLineString);
    }
}
