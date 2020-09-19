package com.netease.spring.demo.algorithm.leetcode401_500;

import java.util.LinkedList;

/**
 * 回溯法
 * @author fangsida
 * @date 2020/9/19
 */
public class Leetcode494 {

    int res = 0;

    public int findTargetSumWays(int[] nums, int S) {
        backtrack(nums, 0, 0, S);
        return res;
    }

    private void backtrack(int[] nums, int sum, int index, int target) {
        if (index == nums.length) {
            if (sum == target) {
                res++;
            }
            return;
        }

        for (int i = 0; i < 2; i++) {
            boolean plus = (i == 0);
            if (plus) {
                sum += nums[index];
                backtrack(nums, sum, index + 1, target);
                sum -= nums[index];
            } else {
                sum -= nums[index];
                backtrack(nums, sum, index + 1, target);
                sum += nums[index];
            }
        }
    }
}
