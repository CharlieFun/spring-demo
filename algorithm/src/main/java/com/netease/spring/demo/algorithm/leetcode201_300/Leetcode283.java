package com.netease.spring.demo.algorithm.leetcode201_300;

/**
 * https://leetcode-cn.com/problems/move-zeroes/
 * 移动零
 *
 * @author fangsida
 * @date 2020/2/21
 */
public class Leetcode283 {

    public void moveZeroes(int[] nums) {
        int notZeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, i, notZeroIndex);
                notZeroIndex++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
