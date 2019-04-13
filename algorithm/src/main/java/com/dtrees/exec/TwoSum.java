package com.dtrees.exec;

/**
 * project:java-code
 * file:TwoSum
 * package:com.dtrees.exec
 * date:2019/4/12 11:06 PM
 * author:keithl
 */
public class TwoSum {

    public static void main(String[] args){
        Solution s = new Solution();
        int[] nums = {2, 9, 11, 7};
        int target = 9;
        int[] result = s.twoSum(nums, target);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}


class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] indexes = new int[2];
        int len = nums.length;
        int sum = 0;
        for(int i = 0; i < len; i++){
            for (int j = 1; j < len; j++){
                sum = nums[i] + nums[j];
                if (sum == target){
                    indexes[0] = i;
                    indexes[1] = j;
                    return indexes;
                }
            }

        }
        return null;
    }
}