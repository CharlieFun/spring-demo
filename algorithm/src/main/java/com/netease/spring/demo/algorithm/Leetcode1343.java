package com.netease.spring.demo.algorithm;

/**
 * @author fangsida
 * @date 2020/7/12
 */
public class Leetcode1343 {

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        if (arr == null || arr.length < k) {
            return 0;
        }

        int index = 0;
        int count = 0;
        while (index + k - 1 < arr.length) {
            if (sum(arr, index, index + k - 1) >= k * threshold) {
                count++;
            }
            index++;
        }

        return count;
    }

    private int sum(int[] arr, int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
