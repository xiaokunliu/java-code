package com.xiaokunliu.interview.j2se.javase.ObjectAPITest;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.FieldPosition;
import java.text.NumberFormat;

public class DecimalFormatTest {

    public static void main(String[] args) {

        double d1 = 9.24;
        double d2 = 9.27;
        DecimalFormat format = new DecimalFormat("0.0");
        //DecimalFormat 提供 RoundingMode 中定义的舍入模式进行格式化。默认情况下，它使用 RoundingMode.HALF_EVEN。
        /*
         * 向最接近数字方向舍入的舍入模式，如果与两个相邻数字的距离相等，则向相邻的偶数舍入。如果舍弃部分左边的数字为奇数，
         * 则舍入行为同 RoundingMode.HALF_UP；如果为偶数，则舍入行为同 RoundingMode.HALF_DOWN
         * 注意，在重复进行一系列计算时，此舍入模式可以在统计上将累加错误减到最小。
         * 此舍入模式也称为“银行家舍入法”，主要在美国使用。此舍入模式类似于 Java 中对 float 和 double 算法使用的舍入策略
         *
         * 需要查看API的RoundingMode的字段说明
         */
//		System.out.println(format.format(d1));//9.2
//		System.out.println(format.format(d2));//9.3

        //UP:远离零方向舍入的舍入模式。始终对非零舍弃部分前面的数字加 1。注意，此舍入模式始终不会减少计算值的绝对值
//		format.setRoundingMode(RoundingMode.UP);
//		System.out.println(format.format(d1));//9.3
//		System.out.println(format.format(d2));//9.3

        //DOWN:向零方向舍入的舍入模式。从不对舍弃部分前面的数字加 1（即截尾）。注意，此舍入模式始终不会增加计算值的绝对值。
        format.setRoundingMode(RoundingMode.DOWN);
        System.out.println(format.format(d1));//9.2
        System.out.println(format.format(d2));//9.2


//		defaultFromat(d1);
//		decimalFormatSymbol(d1);
    }


    public static void decimalFormatSymbol(double d1) {
        /*
         * 此类表示了 DecimalFormat 格式化数字所需的符号集（如小数点、组分隔符等等）。
         * DecimalFormat 根据其语言环境数据为其自身创建一个 DecimalFormatSymbols 实例。
         * 如果需要更改这些符号，可从 DecimalFormat 获得 DecimalFormatSymbols 对象并修改它。
         */
        DecimalFormat decimalFormat = new DecimalFormat("0.00", DecimalFormatSymbols.getInstance());//19.79
//		DecimalFormat decimalFormat=new DecimalFormat("0.00",DecimalFormatSymbols.getInstance(Locale.GERMANY));//19,79
        String str = decimalFormat.format(d1);
        System.out.println(str);
    }


    public static void defaultFromat(double d1) {
        DecimalFormat decimalFormat = new DecimalFormat();//默认格式为0.000
        String str = decimalFormat.format(d1);
        System.out.println(str);//89.789/9.789
//		decimalFormat(d1);

        StringBuffer result = new StringBuffer("dhuhduwh");//将此字符串追加到数字前面
		/*
		 * StringBuffer format(double number, StringBuffer result, FieldPosition fieldPosition) 
          			格式化一个 double 值，以生成一个字符串。 
          
		 */
//		result=decimalFormat.format(d1, result, new FieldPosition(NumberFormat.INTEGER_FIELD));//dhuhduwh9.789
        result = decimalFormat.format(d1, result, new FieldPosition(NumberFormat.FRACTION_FIELD));//dhuhduwh9.789
        System.out.println(result);
    }


    public static void decimalFormat(double d1) {
        DecimalFormat decimalFormat = new DecimalFormat("00.0000");
        String str = decimalFormat.format(d1);
        System.out.println(str);//89.79/09.7888

//		System.out.println(decimalFormat.toLocalizedPattern());//#0.00
//		System.out.println(decimalFormat.toPattern());//#0.00
//		System.out.println(decimalFormat.toString());//java.text.DecimalFormat@674dc
    }

}
