package com.netease.spring.demo.algorithm.leetcode201_300;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/find-the-duplicate-number/submissions/
 * 寻找重复数
 * @author fangsida
 * @date 2020/2/23
 */
public class Leetcode287 {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                return nums[i];
            }
        }

        return -1;
    }
}
