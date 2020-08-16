package com.netease.spring.demo.algorithm;

/**
 * @author fangsida
 * @date 2020/7/12
 */
public class Leetcode1144 {

    public int movesToMakeZigzag(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int min1 = 0, min2 = 0;
        for (int i = 0; i < nums.length; i = i + 2) {
            int lower = findLower(nums, i);
            if (nums[i] < lower) {
                continue;
            } else {
                int diff = nums[i] - lower + 1;
                min1 += diff;
            }
        }

        for (int i = 1; i < nums.length; i = i + 2) {
            int lower = findLower(nums, i);
            if (nums[i] < lower) {
                continue;
            } else {
                int diff = nums[i] - lower + 1;
                min2 += diff;
            }
        }

        return Math.min(min1, min2);
    }

    private int findLower(int[] nums, int index) {
        if (index - 1 < 0) {
            return nums[index + 1];
        }

        if (index + 1 >= nums.length) {
            return nums[index - 1];
        }

        return Math.min(nums[index - 1], nums[index + 1]);
    }
}
