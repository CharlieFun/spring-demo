package com.netease.spring.demo.algorithm.leetcode101_200;

/**
 * @author fangsida
 * @date 2020/2/15
 */
public class Leetcode136 {
    //相同数字异或为0
    public int singleNumber(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans = ans ^ nums[i];
        }

        return ans;
    }
}
