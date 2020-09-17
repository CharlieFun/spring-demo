package com.netease.spring.demo.algorithm.leetcode201_300;

/**
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * 数组中的第K个最大元素
 *
 * @author fangsida
 * @date 2020/2/22
 */
public class Leetcode215 {
    public int findKthLargest(int[] nums, int k) {
        buildHeap(nums, k);
        for (int i = k; i < nums.length; i++) {
            if (nums[i] < nums[0]) {
                continue;
            }
            swap(nums, 0, i);
            downAdjust(nums, 0, k);
        }

        return nums[0];
    }

    private void downAdjust(int[] nums, int parent, int len) {
        int temp = nums[parent];
        int child = parent * 2 + 1;
        while (child < len) {
            if (child + 1 < len && nums[child + 1] < nums[child]) {
                child++;
            }

            if (temp <= nums[child]) {
                break;
            }

            nums[parent] = nums[child];
            parent = child;
            child = 2 * child + 1;
        }

        nums[parent] = temp;
    }

    private void buildHeap(int[] nums, int k) {
        for (int i = k / 2; i >= 0; i--) {
            downAdjust(nums, i, k);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
