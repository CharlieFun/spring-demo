package com.netease.spring.demo.algorithm.leetcode1001_1100;

import com.netease.spring.demo.algorithm.leetcode1_100.Leetcode1;

/**
 * @author fangsida
 * @date 2021/1/2
 */
public class Leetcode1043 {

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int j = i - 1;
            int max = dp[i];
            while ((i - j) <= k && j >= 0) {
                max = Math.max(max, arr[j]);
                dp[i] = Math.max(dp[i], dp[j] + (i - j) * max);
                j--;
            }
        }
        return dp[n];

    }
}
