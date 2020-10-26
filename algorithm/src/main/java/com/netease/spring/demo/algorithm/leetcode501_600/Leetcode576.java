package com.netease.spring.demo.algorithm.leetcode501_600;

/**
 * @author fangsida
 * @date 2020/10/26
 */
public class Leetcode576 {

    int MOD = 1000000007;


    public int findPaths(int m, int n, int N, int i, int j) {
        long[][][] dp = new long[m + 2][n + 2][N + 1];

        for (int row = 0; row < m + 2; row++) {
            dp[row][0][0] = 1;
            dp[row][n + 1][0] = 1;

        }

        for (int col = 0; col < n + 2; col++) {
            dp[0][col][0] = 1;
            dp[m + 1][col][0] = 1;
        }

        for (int x = 1; x < N + 1; x++) {
            for (int y = 1; y < m + 1; y++) {
                for (int z = 1; z < n + 1; z++) {
                    dp[y][z][x] = dp[y + 1][z][x - 1] % MOD + dp[y - 1][z][x - 1] % MOD + dp[y][z + 1][x - 1] % MOD + dp[y][z - 1][x - 1] % MOD;
                }
            }
        }

        long sum = 0;
        for (int x = 1; x < N + 1; x++) {
            sum = (sum + dp[i + 1][j + 1][x]) % MOD;
        }

        return (int)sum;
    }
}
