package com.netease.spring.demo.algorithm.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author fangsida
 * @date 2020/5/10
 */
public class Leetcode797 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        LinkedList<Integer> track = new LinkedList<>();
        track.add(0);

        backTrack(graph, track, 0, graph.length - 1);
        return res;

    }


    private void backTrack(int[][] graph, LinkedList<Integer> track, int index, int target) {
        for (int i = 0; i < graph[index].length; i++) {
            if (graph[index][i] == target) {
                List<Integer> list = new ArrayList<>(track);
                list.add(target);
                res.add(list);
            } else {
                track.add(graph[index][i]);
                backTrack(graph, track, graph[index][i], target);
                track.removeLast();
            }
        }
    }
}
