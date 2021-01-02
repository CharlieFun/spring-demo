package com.netease.spring.demo.algorithm.leetcode1001_1100;

/**
 * @author fangsida
 * @date 2021/1/2
 */
public class Leetcode1039 {

    int minScoreTriangulation(int[] A) {
        int n = A.length;
        int[][] dp = new int[n][n];

        for (int i = n-3; i >= 0; i--) {
            for (int j = i + 2; j < n;j++) {
                for (int m = i + 1; m < j; m++) {
                    if(dp[i][j]==0)
                        dp[i][j]= A[i] * A[j] * A[m] + dp[i][m] + dp[m][j];
                    else
                        dp[i][j] = Math.min(dp[i][j],A[i] * A[j] * A[m] + dp[i][m] + dp[m][j]);
                }
            }
        }
        return dp[0][n - 1];
    }


}
