package com.netease.spring.demo.algorithm.leetcode201_300;

import java.util.Arrays;

/**
 * @author fangsida
 * @date 2020/10/8
 */
public class Leetcode213 {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        return Math.max(myRob(nums, 0, n - 2),
                myRob(nums, 1, n-1));

    }
//
//    public int myRob(int[] nums, int start, int end){
//        int[] dp = new int[nums.length+2];
//
//        for (int i=end;i>=start;i--){
//            dp[i] = Math.max(dp[i+1],dp[i+2] + nums[i]);
//        }
//
//        return dp[start];
//    }

    // 仅计算闭区间 [start,end] 的最优结果
    int myRob(int[] nums, int start, int end) {
        int n = nums.length;
        int dp_i_1 = 0, dp_i_2 = 0;
        int dp_i = 0;
        for (int i = end; i >= start; i--) {
            dp_i = Math.max(dp_i_1, nums[i] + dp_i_2);
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }
        return dp_i;
    }


}
