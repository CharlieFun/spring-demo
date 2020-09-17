package com.netease.spring.demo.algorithm.leetcode1_100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations/
 * 全排列
 *
 * @author fangsida
 * @date 2020/2/15
 */
public class Leetcode46 {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backTrack(nums, track);
        return ans;
    }

    private void backTrack(int[] nums, LinkedList<Integer> track) {
        if (track.size() == nums.length) {
            ans.add(new ArrayList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) {
                continue;
            }
            track.add(nums[i]);
            backTrack(nums, track);
            track.removeLast();
        }
    }
}
