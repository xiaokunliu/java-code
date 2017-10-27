package com.dtrees.datastruct;

/**
 * Created by keithl on 2017/10/21.
 */

public class AlgorithmsAnalysis {

    // 算法分析
    public static int sum(int n) {
        int sum;       // 声明
        sum = 0;       // 赋值,这时候占用一个时间单元

        // 注意for 循环的执行顺序是先赋值,然后进行判断比较,接着就是执行语句,
        // 进行i++,再进行判断,再执行语句
        // ...
        // i++,再进行判断,n+1
        for (int index = 0;index <=n; index++){
            sum += index * index * index;       // 两次乘法 + 一次加法  + 一次赋值  =  4个时间单元,并且计算N次,共有4N
        }

        return sum; // 也占用一个时间单元
    }

    public static void main(String[] args) {

    }
}
