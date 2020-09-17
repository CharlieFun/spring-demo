package com.netease.spring.demo.algorithm.leetcode101_200;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/house-robber/
 * 打家劫舍
 *
 * @author fangsida
 * @date 2020/2/16
 */
public class Leetcode198 {

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[nums.length - 1];
    }
}
