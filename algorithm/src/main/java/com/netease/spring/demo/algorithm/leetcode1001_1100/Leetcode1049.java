package com.netease.spring.demo.algorithm.leetcode1001_1100;

/**
 * @author fangsida
 * @date 2021/1/2
 */
public class Leetcode1049 {

    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += stones[i];
        }

        int[][] dp = new int[n + 1][sum / 2 + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum / 2; j++) {
                if (stones[i-1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j - stones[i-1]] + stones[i-1]);
                }
            }
        }

        return sum - 2 * dp[n][sum / 2];
    }
}
