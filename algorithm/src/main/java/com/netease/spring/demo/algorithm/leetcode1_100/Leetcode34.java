package com.netease.spring.demo.algorithm.leetcode1_100;

/**
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 在排序数组中查找元素的第一个和最后一个位置
 *
 * @author funstar
 * @date 2020/2/11
 */
public class Leetcode34 {

    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};

        if (nums.length == 0) {
            return ans;
        }
        int leftIdx = findIndex(nums, target, true);

        if (leftIdx < 0 || leftIdx == nums.length) {
            return ans;
        }

        int rightIdx = findIndex(nums, target, false);
        ans[0] = leftIdx;
        ans[1] = rightIdx;
        return ans;
    }

    private int findIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target) {
                hi = mid;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                if (left) {
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
            }
        }

        if (lo < nums.length && nums[lo] == target) {
            return lo;
        } else if (lo - 1 >= 0 && nums[lo - 1] == target) {
            return lo - 1;
        } else {
            return -1;
        }

    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        Leetcode34 ins = new Leetcode34();
        System.out.println(ins.searchRange(nums, target));
    }
}
