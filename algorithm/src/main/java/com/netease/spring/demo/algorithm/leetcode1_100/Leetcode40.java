package com.netease.spring.demo.algorithm.leetcode1_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author fangsida
 * @date 2020/11/19
 */
public class Leetcode40 {

    List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        Leetcode40 ins = new Leetcode40();
        int[] arr = {10, 1, 2, 7, 6, 1, 5};
        System.out.println(ins.combinationSum2(arr, 8));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        LinkedList<Integer> track = new LinkedList<>();

        Arrays.sort(candidates);
        int sum = 0;

        backTack(candidates, sum, target, track, 0);
        return res;
    }

    private void backTack(int[] candidates, int sum, int target, LinkedList<Integer> track, int start) {
        if (sum == target) {
            res.add(new ArrayList<>(track));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (sum + candidates[i] > target) {
                break;
            }

            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            sum += candidates[i];
            track.add(candidates[i]);
            backTack(candidates, sum, target, track, i+1);
            track.removeLast();
            sum -= candidates[i];

        }
    }
}
