package com.netease.spring.demo.algorithm.leetcode101_200;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/majority-element/solution/qiu-zhong-shu-by-leetcode-2/
 * 多数元素
 * @author fangsida
 * @date 2020/2/16
 */
public class Leetcode169 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

}
