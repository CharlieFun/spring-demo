package com.netease.spring.demo.algorithm.leetcode501_600;

import com.netease.spring.demo.algorithm.leetcode601_700.Leetcode650;

/**
 * @author fangsida
 * @date 2020/10/25
 */
public class Leetcode523 {

    public static void main(String[] args) {
        int[] arr = {5,0,0};
        Leetcode523 instance = new Leetcode523();
        System.out.println(instance.checkSubarraySum(arr, 0));
    }

    public boolean checkSubarraySum(int[] nums, int k) {

        int[] sum = new int[nums.length + 1];

        int tempSum = 0;
        for (int i = 0; i < nums.length; i++) {
            tempSum += nums[i];
            sum[i + 1] = tempSum;
        }

        for (int i = 2; i < sum.length; i++) {
            for (int j = 0; j < i - 1; j++) {
                int diff = sum[i] - sum[j];
                if (diff == 0 && k == 0) {
                    return true;
                } else if (k == 0) {
                    continue;
                } else if (diff % k == 0) {
                    return true;
                }

            }
        }

        return false;
    }
}
