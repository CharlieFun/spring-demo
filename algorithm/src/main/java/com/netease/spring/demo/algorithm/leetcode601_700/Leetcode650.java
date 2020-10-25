package com.netease.spring.demo.algorithm.leetcode601_700;

/**
 * @author fangsida
 * @date 2020/10/19
 */
public class Leetcode650 {

    public int minSteps(int n) {
        int[] dp = new int[n + 1];

        for (int i = 2; i < n + 1; i++) {
            dp[i] = i;

            for (int j = 2; j < n; j++) {
                if (i % j == 0) {
                    dp[i] = Math.min(dp[i], dp[j] + i / j);
                }
            }

        }

        return dp[n];
    }

    public static void main(String[] args) {
        Leetcode650 instance = new Leetcode650();
        System.out.println(instance.minSteps(18));
    }
}
