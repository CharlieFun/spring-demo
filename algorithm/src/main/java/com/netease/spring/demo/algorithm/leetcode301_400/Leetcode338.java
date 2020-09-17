package com.netease.spring.demo.algorithm.leetcode301_400;

/**
 * 思路：动态规划
 *
 * @author fangsida
 * @date 2020/3/22
 */
public class Leetcode338 {

    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        dp[0] = 0;

        for (int i = 0; i <= num; i++) {
            if (i % 2 == 0) {
                dp[i] = dp[i / 2];
            } else {
                dp[i] = dp[i - 1] + 1;
            }
        }

        return dp;
    }
}
