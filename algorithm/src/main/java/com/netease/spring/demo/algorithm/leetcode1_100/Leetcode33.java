package com.netease.spring.demo.algorithm.leetcode1_100;

/**
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 * 搜索旋转排序数组
 *
 * @author funstar
 * @date 2020/2/11
 */
public class Leetcode33 {

    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int index = findReverseIndex(nums);
        int leftIndex = find(nums, target, 0, index);
        if (leftIndex >= 0) {
            return leftIndex;
        }

        int rightIndex = find(nums, target, index + 1, nums.length - 1);
        return rightIndex;
    }

    private int find(int[] nums, int target, int lo, int hi) {
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if (nums[mid] > target) {
                hi = mid - 1;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    private int findReverseIndex(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if (nums[mid] >= nums[0]) {
                if (mid == nums.length - 1) {
                    return -1;
                }
                if (nums[mid + 1] < nums[0]) {
                    return mid;
                } else {
                    lo = mid + 1;
                }
            } else {
                hi = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Leetcode33 ins = new Leetcode33();
        int[] nums = {8, 9, 2, 3, 4};
        int target = 9;
        int ans = ins.search(nums, target);
        System.out.println(ans);
    }
}
