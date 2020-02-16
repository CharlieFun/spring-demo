package com.netease.spring.demo.algorithm;

/**
 * https://leetcode-cn.com/problems/sort-colors/solution/yan-se-fen-lei-by-leetcode/
 * 颜色分类
 *
 * @author fangsida
 * @date 2020/2/15
 */
public class Leetcode75 {
    public static void main(String[] args) {
        Leetcode75 ins = new Leetcode75();
        int[] nums = {2, 0, 2, 1, 1, 0};
        ins.sortColors(nums);

    }

    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int cur = 0;
        while (cur <= right) {
            if (nums[cur] == 0) {
                if (left<cur) {
                    swap(nums, left, cur);
                    left++;
                }else{
                    left++;
                    cur++;
                }
            } else if (nums[cur] == 2) {
                if (cur<right) {
                    swap(nums, cur, right);
                }else{
                    cur++;
                }
                right--;
            } else {
                cur++;
            }
        }
    }

    public void swap(int[] nums, int low, int high) {
        if (low > high) {
            return;
        }

        int temp = nums[low];
        nums[low] = nums[high];
        nums[high] = temp;

    }
}
