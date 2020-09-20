package com.netease.spring.demo.algorithm.leetcode501_600;

import java.util.Arrays;

/**
 * @author fangsida
 * @date 2020/9/20
 */
public class Leetcode518 {

    public int change(int amount, int[] coins) {

        int n = coins.length;

        //dp[i][j]含义：只用coins中的前i个硬币的面值，如果想凑出金额j，有dp[i][j]种凑法
        int[][] dp = new int[n + 1][amount + 1];

        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if (coins[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }

            }
        }

        return dp[n][amount];
    }

    //dp[i][...]只和dp[i-1][...]有关，可以压缩成一维数组
    public int change2(int amount, int[] coins) {
        int n = coins.length;

        //dp[j]含义：如果想凑出金额j，有dp[j]种凑法，i只是隐藏了，通过历史数据i来计算下一层i+1
        int[] dp = new int[amount + 1];

        dp[0] = 1;


        for (int i = 1; i < n + 1; i++) {
            //有的题目压缩后需要反过来遍历，这里不需要，因为通过27行可以看出，dp[i][j]依赖的dp[i][j - coins[i - 1]]，是依赖当前行，
            // 所以要先把j前面的更新，所以还是顺序遍历
            for (int j = 1; j < amount + 1; j++) {
                if (coins[i - 1] <= j) {
                    dp[j] = dp[j] + dp[j - coins[i - 1]];
                }

            }
        }

        return dp[amount];
    }
}
