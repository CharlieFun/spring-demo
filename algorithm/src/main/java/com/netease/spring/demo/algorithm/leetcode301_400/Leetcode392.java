package com.netease.spring.demo.algorithm.leetcode301_400;

/**
 * @author fangsida
 * @date 2020/9/24
 */
public class Leetcode392 {

    public boolean isSubsequence(String s, String t) {
        int m = s.length();
        int n = t.length();

        boolean[][] dp = new boolean[m + 1][n + 1];

        for (int i = 0; i < n + 1; i++) {
            dp[0][i] = true;
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }

        return dp[m][n];
    }

    //压缩
    public boolean isSubsequence2(String s, String t) {
        int m = s.length();
        int n = t.length();

        boolean[] dp = new boolean[m + 1];

        dp[0] = true;

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (s.charAt(i-1) == t.charAt(j-1)){
                    dp[i] = dp[i-1];
                }else{
                    dp[i] = dp[i];
                }
            }
        }

        return dp[m];
    }
}
