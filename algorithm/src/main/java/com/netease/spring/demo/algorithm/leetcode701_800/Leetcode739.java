package com.netease.spring.demo.algorithm.leetcode701_800;

import java.util.LinkedList;

/**
 * @author fangsida
 * @date 2020/12/24
 */
public class Leetcode739 {

    public int[] dailyTemperatures(int[] T) {
        LinkedList<Integer> stack = new LinkedList<>();

        int[] res = new int[T.length];
        for (int i = T.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && T[stack.peek()] <= T[i]) {
                stack.pop();
            }

            res[i] = stack.isEmpty() ? 0 : stack.peek() - i;

            stack.push(i);
        }

        return res;
    }
}
