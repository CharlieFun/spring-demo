package com.netease.spring.demo.algorithm.leetcode1_100;

/**
 * @author fangsida
 * @date 2020/9/25
 */
public class Leetcode63 {

    public static void main(String[] args) {
        Leetcode63 instance = new Leetcode63();

        int[][] arr = {{0, 1}};

        System.out.println(instance.uniquePathsWithObstacles(arr));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;


        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    if (j > 0 && obstacleGrid[i][j - 1] != 1) {
                        dp[i][j] += dp[i][j - 1];
                    }

                    if (i > 0 && obstacleGrid[i - 1][j] != 1) {
                        dp[i][j] += dp[i - 1][j];
                    }
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}
