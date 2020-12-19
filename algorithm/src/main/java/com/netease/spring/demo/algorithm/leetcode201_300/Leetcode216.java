package com.netease.spring.demo.algorithm.leetcode201_300;

import com.netease.spring.demo.algorithm.leetcode1_100.Leetcode78;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author fangsida
 * @date 2020/11/21
 */
public class Leetcode216 {

    List<List<Integer>> res = new ArrayList<>();

    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backTrack(k, 0, n, 1);
        return res;
    }

    private void backTrack(int k, int sum, int target, int start) {
        if (k == 0) {
            if (sum == target) {
                res.add(new ArrayList<>(track));
            }
            return;
        }

        if (start > 9) {
            return;
        }


        for (int i = start; i <= 9; i++) {
            sum += i;
//            System.out.println("加了"+i+"加之后sum=" + sum);
            track.add(i);
            backTrack(k - 1, sum, target, i + 1);
            track.removeLast();
            sum -= i;
        }
    }

    public static void main(String[] args) {
        Leetcode216 ins = new Leetcode216();
        System.out.println(ins.combinationSum3(9,45));
    }
}
