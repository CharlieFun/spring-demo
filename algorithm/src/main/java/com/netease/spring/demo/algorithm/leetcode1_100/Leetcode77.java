package com.netease.spring.demo.algorithm.leetcode1_100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author fangsida
 * @date 2020/11/20
 */
public class Leetcode77 {

    List<List<Integer>> res = new ArrayList<>();

    LinkedList<Integer> track = new LinkedList<>();


    public List<List<Integer>> combine(int n, int k) {
        backTrack(n, k, 1);
        return res;
    }

    private void backTrack(int n, int k, int start) {
        if (track.size() == k) {
            res.add(new ArrayList<>(track));
            return;
        }

        for (int i = start; i <= n; i++) {
            track.add(i);
            backTrack(n, k, i + 1);
            track.removeLast();
        }

    }
}
