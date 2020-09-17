package com.netease.spring.demo.algorithm.leetcode1_100;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum/
 * 组合总和
 *
 * @author funstar
 * @date 2020/2/12
 */
public class Leetcode39 {

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        LinkedList<Integer> track = new LinkedList<>();
        Arrays.sort(candidates);
        backTrack(candidates, 0, target, track);
        return res;
    }

    private void backTrack(int[] candidates, int start, int target, LinkedList<Integer> track) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target){
                break;
            }

            track.add(candidates[i]);
            backTrack(candidates,i,target-candidates[i],track);
            track.removeLast();
        }
    }
}

