package com.netease.spring.demo.algorithm.leetcode1_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author fangsida
 * @date 2020/11/20
 */
public class Leetcode90 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();

        Arrays.sort(nums);

        backTack(nums, track, 0);
        return res;
    }

    private void backTack(int[] nums, LinkedList<Integer> track, int start) {
        res.add(new ArrayList<>(track));

        if (start == nums.length) {
            return;
        }

        for (int i = start; i < nums.length; i++) {

            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            track.add(nums[i]);
            backTack(nums, track, i+1);
            track.removeLast();

        }
    }

    public static void main(String[] args) {
        Leetcode90 ins = new Leetcode90();
        int[] arr = {1,2,2};
        System.out.println(ins.subsetsWithDup(arr));
    }
}
