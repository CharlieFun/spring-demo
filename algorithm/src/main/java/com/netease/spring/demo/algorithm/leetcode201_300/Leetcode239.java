package com.netease.spring.demo.algorithm.leetcode201_300;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author fangsida
 * @date 2020/11/14
 */
public class Leetcode239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        MonotonousQueue queue = new MonotonousQueue();
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                queue.offer(nums[i]);
            } else {
                queue.offer(nums[i]);

                res.add(queue.max());

                queue.take(nums[i - k + 1]);
            }
        }

        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }

        return arr;
    }

    class MonotonousQueue {

        LinkedList<Integer> queue = new LinkedList<>();

        public void offer(int n) {
            while (!queue.isEmpty() && queue.getLast() < n) {
                queue.removeLast();
            }

            queue.addLast(n);
        }

        public int max() {
            return queue.peek();
        }

        public void take(int n) {
            if (queue.peek() == n) {
                queue.pop();
            }
        }
    }
}
