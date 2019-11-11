package com.xiaokunliu.commons.objects.date;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import static com.xiaokunliu.commons.objects.date.DateFormatEnums.*;

/**
 * Created by keithl on 2017/10/11.
 */

public final class DateUtility {

    private DateUtility(){}

    /**
     *
     * @param date
     * @return  返回示例:2017-10-08 23:39:00
     */
    public static String formatWithDateTimeLine(Date date){
        return DATE_TIME_LINE_FORMAT.getFormatInstance().format(date);
    }

    /**
     *
     * @param date
     * @return  返回示例:2017-10-08
     */
    public static String formatWithDateLine(Date date){
        return DATE_LINE_FORMAT.getFormatInstance().format(date);
    }

    /**
     *
     * @param date
     * @return  返回示例:2017/10/08 23:39:00
     */
    public static String formateWithDateTimeSlash(Date date){
        return DATE_TIME_SLASH_FORMAT.getFormatInstance().format(date);
    }

    /**
     *
     * @param date
     * @return  返回示例:2017/10/08
     */
    public static String formatWithDateSlash(Date date){
        return DATE_SLASH_FORMAT.getFormatInstance().format(date);
    }

    public static String formatWithMongo(Date date){
        return DATE_TIME_FOR_MONGO.getFormatInstance().format(date);
    }

    /**
     *
     * @param dateTimeLineString,输入必须是类似于:2017-10-08 23:39:00
     * @return
     * @throws ParseException
     */
    public static Date parseWithDateTimeLine(String dateTimeLineString) throws ParseException{
        return DATE_TIME_LINE_FORMAT.getFormatInstance().parse(dateTimeLineString);
    }

    /**
     *
     * @param dateLineString,输入必须是类似于:2017-10-08
     * @return
     * @throws ParseException
     */
    public static Date parseWithDateLine(String dateLineString) throws ParseException{
        return DATE_LINE_FORMAT.getFormatInstance().parse(dateLineString);
    }

    /**
     *
     * @param dateTimeSlash,输入必须是类似于:2017/10/8 09:10:12
     * @return
     * @throws ParseException
     */
    public static Date parseWithDateTimeSlash(String dateTimeSlash) throws ParseException{
        return DATE_TIME_SLASH_FORMAT.getFormatInstance().parse(dateTimeSlash);
    }

    /**
     *
     * @param dateSlash,输入必须是类似于:2017/10/8
     * @return
     */
    public static Date parseWithDateSlash(String dateSlash) throws ParseException{
        return DATE_SLASH_FORMAT.getFormatInstance().parse(dateSlash);
    }

    public static Date parseWithDateMongo(String dateMongo) throws ParseException{
        return DATE_TIME_FOR_MONGO.getFormatInstance().parse(dateMongo);
    }

    /**
     *
     * @return  2017-10-09 09:10:23
     */
    public static String getNowTimeWithDateTimeLine(){
        Calendar nowTime = Calendar.getInstance();
        return formatWithDateTimeLine(nowTime.getTime());
    }

    /**
     *
     * @return  2017-10-09
     */
    public static String getNowTimeWithDateLine(){
        Calendar nowTime = Calendar.getInstance();
        return formatWithDateLine(nowTime.getTime());
    }

    /**
     *
     * @return  2017/10/09 09:23:23
     */
    public static String getNowTimeWithDateTimeSlash(){
        Calendar nowTime = Calendar.getInstance();
        return formateWithDateTimeSlash(nowTime.getTime());
    }

    /**
     *
     * @return  2017/10/09
     */
    public static String getNowTimeWithDateSlash(){
        Calendar nowTime = Calendar.getInstance();
        return formatWithDateSlash(nowTime.getTime());
    }

    /**
     * 获取x年后的时间
     * @param date
     * @param x
     * @return
     */
    public static Date xYearAfter(Date date, int x) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, x);
        setCalendarFirst(cal);
        return cal.getTime();
    }

//    public static int getDaysBetween(Calendar d1, Calendar d2) {
//        if (d1.after(d2)) { // swap dates so that d1 is start and d2 is end
//            Calendar swap = d1;
//            d1 = d2;
//            d2 = swap;
//        }
//
//        int days = d2.get(Calendar.DAY_OF_YEAR) - d1.get(Calendar.DAY_OF_YEAR);
//        int y2 = d2.get(Calendar.YEAR);
//        if (d1.get(Calendar.YEAR) != y2) {
//            d1 = (Calendar) d1.clone();
//            do {
//                days += d1.getActualMaximum(Calendar.DAY_OF_YEAR);
//                d1.add(Calendar.YEAR, 1);
//            } while (d1.get(Calendar.YEAR) != y2);
//        }
//        return days;
//    } // getDaysBetween()
//
//    public static Date xYearBefore(int x) {
//        Calendar cal = Calendar.getInstance();
//        cal.add(Calendar.YEAR, -x);
//        setCalendarFirst(cal);
//        return cal.getTime();
//    }
//
//    public static Calendar xDayBeforeToCal(int x){
//        Calendar cal = Calendar.getInstance();
//        cal.add(Calendar.DAY_OF_YEAR, -x);
//        setCalendarFirst(cal);
//        return cal;
//    }
//
//    public static Date xHourBefore(int x,Date date) {
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(date);
//        cal.add(Calendar.HOUR_OF_DAY, -x);
//        return cal.getTime();
//    }
//
//    public static Date xDayBefore(int x) {
//        Calendar cal = Calendar.getInstance();
//        cal.add(Calendar.DAY_OF_YEAR, -x);
//        setCalendarFirst(cal);
//        return cal.getTime();
//    }
//
//    public static Calendar xDayBeforeEnd(int x){
//        Calendar cal = Calendar.getInstance();
//        cal.add(Calendar.DAY_OF_YEAR, -x);
//        makeMaxInTheDay(cal);
//        return cal;
//    }
//
//    private static void makeMaxInTheDay(Calendar cal) {
//        counstructCalendarLast(cal);
//        cal.set(Calendar.MILLISECOND, 999);
//    }
//
//    private static void counstructCalendarLast(Calendar calendar) {
//        calendar.set(Calendar.HOUR_OF_DAY, 23);
//        calendar.set(Calendar.MINUTE, 59);
//        calendar.set(Calendar.SECOND, 59);
//    }
//
    private static void setCalendarFirst(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, 00);
        calendar.set(Calendar.MINUTE, 00);
        calendar.set(Calendar.SECOND, 00);
        calendar.set(Calendar.MILLISECOND, 000);
    }
//
//    public static Date xDayAfter(Date date, int x) {
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(date);
//        cal.add(Calendar.DAY_OF_YEAR, x);
//        setCalendarFirst(cal);
//        return cal.getTime();
//    }
//
//
//    public static Date xYearAfter(int x) {
//        Calendar cal = Calendar.getInstance();
//        return xYearAfter(cal.getTime(), x);
//    }
//
//    public static Date xt2Date(XMLGregorianCalendar xt) {
//        return xt.toGregorianCalendar().getTime();
//        //return chgDateTimezone(xt.toGregorianCalendar().getTime(), "MST");
//    }
//
//    public static Date chgDateTimezone(XMLGregorianCalendar xt, String dstTimeZoneId) {
//        int diffTime = TimeZone.getDefault().getRawOffset() - TimeZone.getTimeZone(dstTimeZoneId).getRawOffset();
//        long nowTime = xt.toGregorianCalendar().getTime().getTime();
//        long newNowTime = nowTime - diffTime;
//        return new Date(newNowTime);
//    }
//
//    /**
//     * @param beforeTime
//     * @param afterTime
//     * @return 0:beforeTime = afterTime,-1:beforeTime > afterTime,1:beforeTime < afterTime
//     */
//    public static int compareTime(Calendar beforeTime,Calendar afterTime){
//        if(beforeTime.before(afterTime)){
//            return 1;
//        }
//        if(beforeTime.after(afterTime)){
//            return -1;
//        }
//        return  0;
//    }
//
//    public static Calendar getMinsOneDayByEbayTime(Calendar ebayTime){
//        Calendar minsOneDayTime = (Calendar)ebayTime.clone();
//        minsOneDayTime.set(Calendar.DATE,-1);
//        return  minsOneDayTime;
//    }
//
//    public static String getMinsDaysByCurrentTime(int dayNums){
//        Calendar currentTime = Calendar.getInstance();
//        currentTime.add(Calendar.DATE,dayNums);
//        return formatWithDateTimeLine(currentTime.getTime());
//    }
//
//    public static String getMinsDaysByTimeStr(int dayNums,Calendar time){
//        time.add(Calendar.DATE,dayNums);
//        return formatWithDateTimeLine(time.getTime());
//    }
//
//    public static Calendar getMinsDaysZeroTime(int dayNums,Calendar time){
//        time.add(Calendar.DATE,dayNums);
//        time.set(Calendar.HOUR,0);
//        time.set(Calendar.MINUTE,0);
//        time.set(Calendar.SECOND,0);
//        return time;//getDateStrWithTime(time.getTime());
//    }
//
//    public static Calendar getMinsDaysLastTime(int dayNums,Calendar time){
//        time.add(Calendar.DATE,dayNums);
//        time.set(Calendar.HOUR,23);
//        time.set(Calendar.MINUTE,59);
//        time.set(Calendar.SECOND,59);
//        return time;//getDateStrWithTime(time.getTime());
//    }
//
//    public static Calendar getMinsDaysByTime(int dayNums,Calendar time){
//        time.add(Calendar.DATE,dayNums);
//        return time;
//    }
//
//    public static String getDayOfWeek(Calendar time){
//        switch (time.get(Calendar.DAY_OF_WEEK)){
//            case Calendar.SUNDAY:
//                return "SUNDAY";
//            case Calendar.MONDAY:
//                return "MONDAY";
//            case Calendar.TUESDAY:
//                return "TUESDAY";
//            case Calendar.WEDNESDAY:
//                return "WEDNESDAY";
//            case Calendar.THURSDAY:
//                return "THURSDAY";
//            case Calendar.FRIDAY:
//                return "FRIDAY";
//            case Calendar.SATURDAY:
//                return "SATURDAY";
//        }
//        return null;
//    }
}
