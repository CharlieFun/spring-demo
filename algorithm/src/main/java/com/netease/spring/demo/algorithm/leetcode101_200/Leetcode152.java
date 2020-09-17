package com.netease.spring.demo.algorithm.leetcode101_200;

/**
 * https://leetcode-cn.com/problems/maximum-product-subarray/
 * 乘积最大子序列
 *
 * @author fangsida
 * @date 2020/2/16
 */
public class Leetcode152 {
    public static void main(String[] args) {
        Leetcode152 ins = new Leetcode152();
        int[] nums = {2, 3, 0, 2};
        System.out.println(ins.maxProduct(nums));
    }

    public int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int max = 1;
        int min = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = max;
                max = min;
                min = temp;
            }

            max = Math.max(max * nums[i], nums[i]);
            min = Math.min(min * nums[i], nums[i]);

            ans = Math.max(ans, max);
        }

        return ans;
    }
}
