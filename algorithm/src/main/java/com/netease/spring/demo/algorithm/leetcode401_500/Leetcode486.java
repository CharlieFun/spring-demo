package com.netease.spring.demo.algorithm.leetcode401_500;

/**
 * @author fangsida
 * @date 2020/10/25
 */
public class Leetcode486 {

    public boolean PredictTheWinner(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][len];

        for (int i = 0; i < len; i++) {
            dp[i][i] = nums[i];
        }

        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }

        return dp[0][len - 1] > 0;
    }
}
