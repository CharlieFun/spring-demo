package com.netease.spring.demo.algorithm.leetcode801_900;

/**
 * @author fangsida
 * @date 2021/1/1
 */
public class Leetcode877 {

    public boolean stoneGame(int[] piles) {
        int n = piles.length;

        Pair[][] dp = new Pair[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = new Pair(0, 0);
            }
        }

        for (int i = 0; i < n; i++) {
            dp[i][i].fir = piles[i];
            dp[i][i].sec = 0;

        }

        for (int l = 2; l <= n; l++) {
            for (int i = 0; i <= n - l; i++) {
                int j = l + i - 1;
                int left = piles[i] + dp[i + 1][j].sec;
                int right = piles[j] + dp[i][j - 1].sec;
                if (left > right) {
                    dp[i][j].fir = left;
                    dp[i][j].sec = dp[i + 1][j].fir;
                } else {
                    dp[i][j].fir = right;
                    dp[i][j].sec = dp[i][j - 1].fir;
                }
            }
        }

        return dp[0][n - 1].fir - dp[0][n - 1].sec > 0;
    }

    private static class Pair {
        public int fir;

        public int sec;

        public Pair(int fir, int sec) {
            this.fir = fir;
            this.sec = sec;
        }
    }
}
