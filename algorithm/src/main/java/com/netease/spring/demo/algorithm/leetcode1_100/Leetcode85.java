package com.netease.spring.demo.algorithm.leetcode1_100;

/**
 * @author fangsida
 * @date 2020/9/26
 */
public class Leetcode85 {

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }

        int[][] dp = new int[matrix.length][matrix[0].length];
        int maxArea = 0;


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = j == 0 ? 1 : dp[i][j - 1] + 1;

                    int minWidth = dp[i][j];

                    for (int k = i; k >= 0; k--) {
//                        if (dp[k][j] == '0'){
//                            break;
//                        }
                        minWidth = Math.min(minWidth, dp[k][j]);
                        maxArea = Math.max(maxArea, minWidth * (i - k + 1));
                    }
                }
            }
        }

        return maxArea;
    }
}
