package com.netease.spring.demo.algorithm.leetcode301_400;

/**
 * @author fangsida
 * @date 2020/9/28
 */
public class Leetcode343 {

    public int integerBreak(int n) {
        int[] dp = new int[n+1];

        dp[1] = 1;
        dp[2] = 1;

        for (int i=3;i<=n;i++){
            for (int j=i-1;j>=1;j--){
                dp[i] = Math.max(Math.max(dp[i],dp[j] * (i-j)),j*(i-j));
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Leetcode343 instance = new Leetcode343();
        System.out.println(instance.integerBreak(10));
    }
}
