package com.netease.spring.demo.algorithm.backTracking;

import java.util.LinkedList;

/**
 * @author fangsida
 * @date 2020/5/7
 */
public class Leetcode526 {

    int res = 0;

    public int countArrangement(int N) {
        LinkedList<Integer> track = new LinkedList<>();
        backTrack(N,track);
        return res;
    }

    private void backTrack(int n, LinkedList<Integer> track) {
        if (track.size() == n){
            res++;
            return;
        }

        for (int i=1;i<=n;i++){
            if (track.contains(i) || !isBeautiful(i,track.size()+1)){
                continue;
            }

            track.add(i);
            backTrack(n,track);
            track.removeLast();
        }
    }

    private boolean isBeautiful(int value, int index) {
        return value % index == 0 || index % value == 0;
    }
}
