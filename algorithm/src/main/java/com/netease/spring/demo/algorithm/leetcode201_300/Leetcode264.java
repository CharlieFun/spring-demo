package com.netease.spring.demo.algorithm.leetcode201_300;

/**
 * @author fangsida
 * @date 2020/9/28
 */
public class Leetcode264 {

    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;

        int i2 =0,i3=0,i5=0;

        for(int i=1;i<n;i++){
            dp[i] = Math.min(Math.min(dp[i2]*2,dp[i3]*3),dp[i5]*5);

            if (dp[i2]*2 == dp[i]) i2++;
            if (dp[i3]*3 == dp[i]) i3++;
            if (dp[i5]*5 == dp[i]) i5++;
        }

        return dp[n-1];
    }
}
