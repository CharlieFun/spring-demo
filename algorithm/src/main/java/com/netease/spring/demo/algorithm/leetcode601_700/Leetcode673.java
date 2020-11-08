package com.netease.spring.demo.algorithm.leetcode601_700;

import java.util.Arrays;

/**
 * @author fangsida
 * @date 2020/10/26
 */
public class Leetcode673 {

    public static void main(String[] args) {
        Leetcode673 instance = new Leetcode673();
        int[] nums = {1, 2, 4, 3, 5, 4, 7, 2};
        int count = instance.findNumberOfLIS(nums);
        System.out.println(count);
    }

    public int findNumberOfLIS(int[] nums) {
        int len = nums.length;
        int[] lenArr = new int[len];
        int[] countArr = new int[len];
        Arrays.fill(lenArr, 1);
        Arrays.fill(countArr, 1);

        int maxLen = 1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (lenArr[i] <= lenArr[j]) {
                        lenArr[i] = lenArr[j] + 1;
                        countArr[i] = countArr[j];
                    } else if (lenArr[i] == lenArr[j] + 1) {
                        countArr[i] += countArr[j];
                    }

                    maxLen = Math.max(maxLen, lenArr[i]);

                }
            }
        }

        int count = 0;
        for (int i = 0; i < len; i++) {
            if (lenArr[i] == maxLen) {
                count += countArr[i];
            }
        }

        return count;

    }
}
