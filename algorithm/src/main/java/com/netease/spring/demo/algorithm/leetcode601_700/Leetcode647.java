package com.netease.spring.demo.algorithm.leetcode601_700;

/**
 * @author fangsida
 * @date 2020/10/19
 */
public class Leetcode647 {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        int count = 0;
        for (int i = n-1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    dp[i][j] = true;
                    count++;
                } else if (j - i == 1 && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    count++;
                } else if (j - i > 1 && s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    count++;
                }
            }
        }

        return count;
    }
}
