package com.netease.spring.demo.algorithm;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/coin-change/
 * 零钱兑换
 * 思路：动态规划
 *
 * @author fangsida
 * @date 2020/2/23
 */
public class Leetcode322 {

    public int coinChange(int[] coins, int amount) {
//        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        dp[0] = 0;
//        for (int i = 0; i < coins.length; i++) {
//            dp[coins[i]] = 1;
//        }

        for (int i = 1; i < amount + 1; i++) {
            int tempRes = Integer.MAX_VALUE;
            boolean flag = false;
            for (int j = 0; j < coins.length; j++) {
                if (i < coins[j]) {
                    continue;
                } else {
                    int pre = i - coins[j];
                    if (dp[pre] >= 0) {
                        flag = true;
                        tempRes = Math.min(tempRes, dp[pre] + 1);
                    }
                }
            }

            dp[i] = flag ? tempRes : -1;
        }

        return dp[amount];

    }

}
