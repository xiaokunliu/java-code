package com.xiaokunliu.common.idkey;

import java.util.Random;

/**
 * project:shop
 * file:IdGenerator
 * package:com.dtreess.common.idkey
 * date:2018/3/14 上午6:22
 * author:keithl
 */
public final class IdGenerator {

    private final static String ORDER_PREFIX = "D";
    private final static int MAX_NUMBER = 99;
    private static Random RANDOM;

    static {
        RANDOM = new Random();
    }

    // 生成订单Id的规则,16位
    public static String createOrderId(){
        // 前缀 + unix后13位的时间戳(毫秒) + 后两位随机
        StringBuffer orderCode = new StringBuffer();
        orderCode.append(ORDER_PREFIX);
        orderCode.append(System.currentTimeMillis());
        int randomNum = RANDOM.nextInt(MAX_NUMBER);
        if (randomNum < 10){
            orderCode.append("0"+randomNum);
        }else{
            orderCode.append(randomNum);
        }
        return orderCode.toString();
    }

    public static String createCategoryId(){
        StringBuffer categoryId = new StringBuffer();
        long time = System.currentTimeMillis();
        long seconds = (time / 1000);
        categoryId.append(seconds);
        int randomNum = RANDOM.nextInt(MAX_NUMBER);
        if (randomNum < 10){
            categoryId.append("0"+randomNum);
        }else{
            categoryId.append(randomNum);
        }
        return categoryId.toString();
    }

//    public static void main(String[] args) {
//        System.out.println(createCategoryId());
//        System.out.println(createOrderId());
//    }
}
