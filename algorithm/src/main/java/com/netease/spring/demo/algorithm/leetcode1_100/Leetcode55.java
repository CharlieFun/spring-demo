package com.netease.spring.demo.algorithm.leetcode1_100;

/**
 * https://leetcode-cn.com/problems/jump-game/
 * 跳跃游戏
 *
 * @author fangsida
 * @date 2020/2/15
 */
public class Leetcode55 {

    public static void main(String[] args) {
        Leetcode55 ins = new Leetcode55();
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println(ins.canJump(nums1));

        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.println(ins.canJump(nums2));
    }


    public boolean canJump(int[] nums) {
        if (nums.length < 2) {
            return true;
        }

        //从后往前找，如果nums[i]>=nums.length-1-i,说明该点能到最后位置，下一步判断能否到达nums[i]
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] >= nums.length - 1 - i) {
                return canJump(nums, i);
            }
        }

        return false;
    }

    private boolean canJump(int[] nums, int target) {
        if (target == 0) {
            return true;
        }

        for (int i = target - 1; i >= 0; i--) {
            if (nums[i] >= target - i) {
                return canJump(nums, i);
            }
        }

        return false;
    }
}
