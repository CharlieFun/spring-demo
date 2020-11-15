package com.netease.spring.demo.algorithm.leetcode501_600;

import java.util.LinkedList;

/**
 * @author fangsida
 * @date 2020/11/13
 */
public class Leetcode503 {

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n]; // 存放结果
        LinkedList<Integer> stack = new LinkedList<>();
        // 假装这个数组长度翻倍了
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i % n])
                stack.pop();
            res[i % n] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i % n]);
        }
        return res;

    }

}
