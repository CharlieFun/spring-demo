package com.netease.spring.demo.algorithm;

import com.sun.org.apache.regexp.internal.RE;

/**
 * https://leetcode-cn.com/problems/next-permutation/
 * 下一个排列
 *
 * @author funstar
 * @date 2020/2/10
 */
public class Leetcode31 {

    //优化：下面两次调用quickSort的地方，其实只用反转数组就好了
    public void nextPermutation(int[] nums) {
        if (null == nums || nums.length == 1) {
            return;
        }

        //第一个逆序所在的位置
        int reverseIndex = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                reverseIndex = i - 1;
                break;
            }
        }

        if (reverseIndex < 0) {
            quickSort(nums, 0, nums.length - 1);
            return;
        }

        //第一个比reverseIndex位置大的位置
        int largerIndex = -1;
        for (int i = nums.length - 1; i > reverseIndex; i--) {
            if (nums[i] > nums[reverseIndex]) {
                largerIndex = i;
                break;
            }
        }

        int temp = nums[reverseIndex];
        nums[reverseIndex] = nums[largerIndex];
        nums[largerIndex] = temp;

        quickSort(nums, reverseIndex + 1, nums.length - 1);
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int i = left;
        int j = right;
        int mid = nums[left];
        while (i < j) {
            while (j > i && nums[j] >= mid) {
                j--;
            }

            while (i < j && nums[i] <= mid) {
                i++;
            }

            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }

        }
        nums[left] = nums[i];
        nums[i] = mid;

        quickSort(nums, left, i - 1);
        quickSort(nums, i + 1, right);

    }
}
