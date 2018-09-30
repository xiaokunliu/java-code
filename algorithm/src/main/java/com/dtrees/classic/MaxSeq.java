package com.dtrees.classic;

/**
 * project:keithl
 * file:MaxSeq
 * package:com.dtrees.classic
 * date:2018/9/30 下午11:46
 * author:keithl
 */
public class MaxSeq {

    /**
     * 最大子序列和
     给定整数A1,A2,...An，求序列中（i,j）序列Ai+...+Aj最大值（i>=1,j<=n）,如果所有整数均为负数,则最大子序列和是0
     */
    public static int getMaxSubSum(int[] arr){
        if(arr == null || arr.length <= 0){
            return 0;
        }
        int sum = 0;
        int len = arr.length;
        for (int i =0;i < len;i++){
            for (int j = 0;j < len;j++){
                int thisSum = 0;
                for (int k=i;k<=j;k++){
                    thisSum += arr[k];
                }
                if(thisSum > sum){
                    sum = thisSum;
                }
            }
        }
        return sum;
    }

    public static int getMaxSubSum2(int[] arr) {
        if(arr == null || arr.length <= 0){
            return 0;
        }
        int sum = 0;
        int len = arr.length;
        for (int i=0;i<len;i++){
            int thisSum = 0;
            for (int j=i;j<len;j++){
                thisSum += arr[j];
                if (thisSum > sum) {
                    sum = thisSum;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args){
        int[] arr = {-29,2,8,3,-7,-19,2,5,8,-1};
        int max = getMaxSubSum2(arr);
        System.out.println(max);
    }
}
