package com.netease.spring.demo.algorithm.leetcode601_700;

/**
 * @author fangsida
 * @date 2020/11/2
 */
public class Leetcode698 {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }

        if (sum / k < maxNum || sum % k != 0) {
            return false;
        }

        boolean[] used = new boolean[nums.length];
        return backTrack(nums, 0, 0, sum / k, used, k);
    }

    private boolean backTrack(int[] nums, int index, int curSum, int target, boolean[] used, int k) {
        if (k == 0) {
            return true;
        }

        if (curSum == target) {
            return backTrack(nums, 0, 0, target, used, k - 1);
        }

        for (int i = index; i < nums.length; i++) {
            if (!used[i] && curSum + nums[i] <= target) {
                used[i] = true;
                if (backTrack(nums, i + 1, curSum + nums[i], target, used, k)) {
                    return true;
                }
                used[i] = false;
            }
        }

        return false;
    }
}
