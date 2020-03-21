package com.xiaokunliu.interview.j2se.javase.ObjectAPITest;

import java.util.Calendar;

public class CalendarTest {


    public static void main(String[] args) {

//		int year=2014;
//		showDays(year);
        Calendar c = Calendar.getInstance();
        c.set(2014, 2, 21);
        System.out.println(c);
        //风格有LONG、SHORT
//		c.getTimeZone().setID("beijing");
        /*
         * 键值对
         * java.util.GregorianCalendar
         * 			[time=1391395970675,areFieldsSet=true,areAllFieldsSet=true,lenient=true,
         * 			zone=sun.util.calendar.ZoneInfo[id="Asia/Shanghai",offset=28800000,dstSavings=0,useDaylight=false,transitions=19,lastRule=null],
         * 			firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=2014,MONTH=1,WEEK_OF_YEAR=6,WEEK_OF_MONTH=2,DAY_OF_MONTH=3,DAY_OF_YEAR=34,DAY_OF_WEEK=2,
         * 			DAY_OF_WEEK_IN_MONTH=1,AM_PM=0,HOUR=10,HOUR_OF_DAY=10,MINUTE=52,SECOND=50,MILLISECOND=675,ZONE_OFFSET=28800000,DST_OFFSET=0]
         */
//		System.out.println(c);

//		showDays(year);
    }


    /**
     * @param year 获取某一年份2月的天数
     */
    public static void showDays(int year) {

        Calendar c = Calendar.getInstance();
        c.set(year, 2, 1);
        c.add(Calendar.DAY_OF_MONTH, -1);
//		c.roll(Calendar.DAY_OF_MONTH, -1);
        showDate(c);
    }

    /**
     * @param c
     */
    public static void showDate(Calendar c) {
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int day = c.get(Calendar.DAY_OF_MONTH);
        int week = c.get(Calendar.DAY_OF_WEEK);


        System.out.println(year + "年" + month + "月" + day + "日" + getWeek(week));
    }

    public static String getWeek(int i) {

        String[] weeks = {"", "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};

        return weeks[i];
    }
}
