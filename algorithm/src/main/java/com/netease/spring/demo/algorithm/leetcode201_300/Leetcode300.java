package com.netease.spring.demo.algorithm.leetcode201_300;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * 最长上升子序列
 *
 * @author fangsida
 * @date 2020/2/23
 */
public class Leetcode300 {

    public static void main(String[] args) {
        int[] arr = {10, 9, 2, 5, 3, 17, 101, 14, 15};
        Leetcode300 ins = new Leetcode300();
        System.out.println(ins.lengthOfLIS(arr));
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
