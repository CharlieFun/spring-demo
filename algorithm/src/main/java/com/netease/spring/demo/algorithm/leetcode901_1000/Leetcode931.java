package com.netease.spring.demo.algorithm.leetcode901_1000;

/**
 * @author fangsida
 * @date 2021/1/1
 */
public class Leetcode931 {

    public int minFallingPathSum(int[][] A) {
        int row = A.length;
        int col = A[0].length;

        int[][] dp = new int[row][col];

        for (int j = 0; j < col; j++) {
            dp[0][j] = A[0][j];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (j == 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]) + A[i][j];
                } else if (j == col - 1) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + A[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j + 1])) + A[i][j];
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int j = 0; j < col; j++) {
            res = Math.min(res, dp[row - 1][j]);
        }

        return res;
    }

}
