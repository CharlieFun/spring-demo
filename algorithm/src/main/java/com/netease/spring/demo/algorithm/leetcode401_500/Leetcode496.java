package com.netease.spring.demo.algorithm.leetcode401_500;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author fangsida
 * @date 2020/11/12
 */
public class Leetcode496 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map = new HashMap<>();
        LinkedList<Integer> stack = new LinkedList<>();

        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }

            int nextGreater = stack.isEmpty() ? -1 : stack.peek();
            map.put(nums2[i], nextGreater);

            stack.push(nums2[i]);
        }

        int[] res = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }

        return res;
    }
}
