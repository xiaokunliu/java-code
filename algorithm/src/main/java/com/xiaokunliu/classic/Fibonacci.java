package com.xiaokunliu.classic;

/**
 * Created by keithl on 16-7-19.
 */
public class Fibonacci {

    /**
     * the suituaction as follow:
     *       1 1 2 3 5 8 13 21 34 55 89
     *       f(n) = f(n-1)+f(n-2)
      */

    public static void main(String[] args){
        for(int i=1;i<=10;i++){
            System.out.print(FibonacciFn(i)+" ");
        }
    }

    public static int FibonacciFn(int n){
        if(n > 2){
            return FibonacciFn(n-1) + FibonacciFn(n-2);
        }
        return 1;
    }
}


