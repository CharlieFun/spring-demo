package com.netease.spring.demo.algorithm.leetcode401_500;

/**
 * @author fangsida
 * @date 2020/9/20
 */
public class Leetcode416 {

    public boolean canPartition(int[] nums) {

        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) {
            return false;
        }


        //dp[i][j]含义：对于nums中的前i个数，当目标和为j时，是否能达到目标和
        boolean[][] dp = new boolean[n + 1][sum / 2];

        for (int i = 0; i < sum / 2; i++) {
            dp[0][i] = false;
        }

        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; i < sum / 2; j++) {
                //直接比j大，只能不选nums[i]
                if (nums[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }

        return dp[n][sum / 2];
    }
}
