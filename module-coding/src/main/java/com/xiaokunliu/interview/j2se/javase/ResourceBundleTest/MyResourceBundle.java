package com.xiaokunliu.interview.j2se.javase.ResourceBundleTest;

import java.util.ResourceBundle;

public class MyResourceBundle {

    private final static String RESOURCEURL = "com.wind.ResourceBundleTest.key";

    // static ResourceBundle getBundle(String baseName)
    // 使用指定的基本名称、默认的语言环境和调用者的类加载器获取资源包。
    private static ResourceBundle myResource = ResourceBundle
            .getBundle(RESOURCEURL);

    public static void main(String[] args) {

        // String name=myResource.getString("name");
        // String pwd=myResource.getString("pwd");
        // System.out.println("name--->"+name);
        // System.out.println("pwd-->"+pwd);

        // Locale getLocale() 返回此资源包的语言环境。
        // Locale cale = myResource.getLocale();
        // System.out.println("cale---"+cale.toString());

        // abstract Enumeration<String> getKeys() 返回键的枚举。
        // Enumeration<String> keys=myResource.getKeys();
        // while(keys.hasMoreElements()){
        // String key=keys.nextElement();
        // String value=myResource.getString(key);
        // System.out.println(key+":"+value);
        // }

        // protected Set<String> handleKeySet()
        // 返回只 包含在此 ResourceBundle 中的键的 Set。
        // for (String key : myResource.keySet()) {
        // String value=myResource.getString(key);
        // System.out.println(key+":"+value);
        // }

        // static void clearCache()
        // 从已经使用调用者的类加载器加载的缓存中移除所有资源包。
        ResourceBundle.clearCache();
        for (String key : myResource.keySet()) {
            String value = myResource.getString(key);
            System.out.println(key + ":" + value);
        }
        // static void clearCache(ClassLoader loader)
        // 从已经使用给定类加载器加载的缓存中移除所有资源包。

    }
}
