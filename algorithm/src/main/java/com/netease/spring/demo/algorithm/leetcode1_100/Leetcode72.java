package com.netease.spring.demo.algorithm.leetcode1_100;

/**
 * @author fangsida
 * @date 2020/9/23
 */
public class Leetcode72 {

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();


        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i < n + 1; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1;
                }
            }
        }

        return dp[m][n];

    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
