package com.xiaokunliu.stduy.javase.ObjectAPITest;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatSymbolsTest {

    public static void main(String[] args) {

//		DateFormatSymbols ds=DateFormatSymbols.getInstance(Locale.US);
//		System.out.println(ds.getLocalPatternChars());
        SimpleDateFormat df = new SimpleDateFormat("yyyy--MM--dd", DateFormatSymbols.getInstance(Locale.US));
        String str = df.format(new Date());
        System.out.println(str);
        System.out.println(df.getDateFormatSymbols().getLocalPatternChars());


    }
}
