package com.xiaokunliu.interview.j2se.javase.ResourceBundleTest;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleResource {

    private static final String baseName = "com.wind.ResourceBundleTest.key";
    //	private static final Locale locale=Locale.getDefault();
//	private static final Locale locale=Locale.getDefault(Locale.Category.FORMAT);
    private static final Locale CNLOCALE = Locale.CHINA;
    //加载资源文件
    private static ResourceBundle res = ResourceBundle.getBundle(baseName, CNLOCALE);

    public static void main(String[] args) {


//		System.out.println(CNLOCALE.getDisplayCountry()+":"+CNLOCALE.getCountry()+":"+CNLOCALE.getLanguage());
//		System.out.println(res);
        for (String key : res.keySet()) {
            //如果存在占位符则将占位符依次替换，否则不替换
            String value = MessageFormat.format(res.getString(key), "	晓");
            System.out.println(key + "---->" + value);
        }
    }


}
