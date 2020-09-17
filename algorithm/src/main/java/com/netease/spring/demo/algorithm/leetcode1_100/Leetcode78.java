package com.netease.spring.demo.algorithm.leetcode1_100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author fangsida
 * @date 2020/2/15
 */
public class Leetcode78 {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {

        LinkedList<Integer> track = new LinkedList<>();
        for (int i = 0; i <= nums.length; i++) {
            backTrack(nums, i, track, 0);
        }
        return ans;
    }

    private void backTrack(int[] nums, int len, LinkedList<Integer> track, int start) {
        if (track.size() == len) {
            ans.add(new ArrayList<>(track));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            track.add(nums[i]);
            backTrack(nums, len, track, i + 1);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        Leetcode78 ins = new Leetcode78();
        int[] nums = {1,2,3};
        System.out.println(ins.subsets(nums));
    }
}
