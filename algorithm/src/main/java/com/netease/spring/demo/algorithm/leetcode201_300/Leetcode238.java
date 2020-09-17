package com.netease.spring.demo.algorithm.leetcode201_300;

/**
 * https://leetcode-cn.com/problems/product-of-array-except-self/
 * 除自身以外数组的乘积
 *
 * @author fangsida
 * @date 2020/2/23
 */
public class Leetcode238 {

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];

        ans[0] = 1;
        for (int i = 1; i < len; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        int r = 1;
        for (int i = len - 1; i >= 0; i--) {
            ans[i] = ans[i] * r;
            r *= nums[i];
        }

        return ans;
    }
}
