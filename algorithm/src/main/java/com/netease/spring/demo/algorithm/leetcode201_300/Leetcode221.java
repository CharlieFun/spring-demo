package com.netease.spring.demo.algorithm.leetcode201_300;

/**
 * 思路：动态规划
 * @author fangsida
 * @date 2020/3/22
 */
public class Leetcode221 {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0){
            return 0;
        }

        if(matrix[0].length == 0){
            return 0;
        }
        int maxSize = maximalSize(matrix);
        return maxSize * maxSize;
    }

    public int maximalSize(char[][] matrix) {
        //dp[i][j]是以matrix[i][j]为正方形的右下角的最大size
        int[][] dp = new int[matrix.length][matrix[0].length];
        int maxSize = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == '1') {
                dp[i][0] = 1;
                maxSize = 1;
            } else {
                dp[i][0] = 0;
            }


        }

        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == '1') {
                dp[0][i] = 1;
                maxSize = 1;
            } else {
                dp[0][i] = 0;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1;
                    maxSize = Math.max(maxSize, dp[i][j]);
                }
            }
        }

        return maxSize;
    }

    private int min(int i, int j, int k) {
        return Math.min(Math.min(i, j), k);
    }
}
