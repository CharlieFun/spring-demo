package com.netease.spring.demo.algorithm.leetcode701_800;

/**
 * @author fangsida
 * @date 2020/11/5
 */
public class Leetcode712 {

    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i=1;i<=m;i++){
            dp[i][0] = dp[i-1][0]+Integer.valueOf(s1.charAt(i-1));
        }

        for (int i=1;i<=n;i++){
            dp[0][i] = dp[0][i-1]+Integer.valueOf(s2.charAt(i-1));
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + Integer.valueOf(s1.charAt(i-1)),
                            dp[i][j - 1] + Integer.valueOf(s2.charAt(j-1)));
                }
            }
        }

        return dp[m][n];
    }
}
