package com.netease.spring.demo.algorithm;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 * 爬楼梯
 *
 * @author fangsida
 * @date 2020/2/15
 */
public class Leetcode70 {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;

        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n - 1];
    }
}
