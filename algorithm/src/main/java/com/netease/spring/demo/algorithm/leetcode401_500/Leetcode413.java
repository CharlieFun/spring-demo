package com.netease.spring.demo.algorithm.leetcode401_500;

/**
 * @author fangsida
 * @date 2020/10/13
 */
public class Leetcode413 {

    public int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3) {
            return 0;
        }

        int n = A.length;
        int[] dp = new int[n];

        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + helper(A, i);
        }

        return dp[n - 1];
    }

    private int helper(int[] arr, int index) {
        int preIndex = index - 1;
        int dif = arr[index] - arr[preIndex];

        while (preIndex > 0 && arr[preIndex] - arr[preIndex - 1] == dif) {
            preIndex--;
        }

        if (index - preIndex + 1 >= 3) {
            return index - preIndex + 1 - 3 + 1;
        } else {
            return 0;
        }
    }
}
