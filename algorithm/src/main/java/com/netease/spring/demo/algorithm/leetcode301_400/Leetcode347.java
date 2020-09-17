package com.netease.spring.demo.algorithm.leetcode301_400;

import com.google.common.collect.Lists;

import java.util.*;

/**
 * @author fangsida
 * @date 2020/3/22
 */
public class Leetcode347 {

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(map::get));

        for (int num : map.keySet()) {
            queue.add(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            list.add(queue.poll());
        }

        Collections.reverse(list);
        return list;

    }

}
