package com.xiaokunliu.j2se.javase.ResourceBundleTest;

import java.util.Locale;

public class LocalTest {

    public static void main(String[] args) {

//			getAllLocales();

//		static Locale getDefault() 
//        		获得此 Java 虚拟机实例的当前默认语言环境值。
        Locale curLocale = Locale.getDefault();
        System.out.println(curLocale.getDisplayCountry() + ":" + curLocale.getLanguage() + ":" + curLocale.getCountry());


    }

    public static void getAllLocales() {
        //		static Locale[] getAvailableLocales() 返回所有已安装语言环境的数组。
        Locale[] locales = Locale.getAvailableLocales();
        for (Locale locale : locales) {
            System.out.println(locale.getDisplayCountry() + "---" +
                    "对应的国家代码：" +
                    locale.getCountry() + "---对应语言代码：" + locale.getLanguage());
        }
    }
}
