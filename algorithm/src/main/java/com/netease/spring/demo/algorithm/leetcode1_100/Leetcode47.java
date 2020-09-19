package com.netease.spring.demo.algorithm.leetcode1_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author fangsida
 * @date 2020/5/10
 */
public class Leetcode47 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {

        LinkedList<Integer> track = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        batckTrack(nums, track, used);
        return res;

    }

    private void batckTrack(int[] nums, LinkedList<Integer> track, boolean[] used) {
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }

                track.add(nums[i]);
                used[i] = true;
                batckTrack(nums, track, used);
                track.removeLast();
                used[i] = false;
            }
        }
    }
}
