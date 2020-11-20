package com.netease.spring.demo.algorithm.leetcode401_500;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author fangsida
 * @date 2020/11/18
 */
public class Leetcode435 {

    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0){
            return 0;
        }

        Arrays.sort(intervals, Comparator.comparingInt((int[] a) -> a[1]));

        int len = intervals.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);

        int maxUpNum = dp[0];
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (intervals[i][0] >= intervals[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            maxUpNum = Math.max(maxUpNum, dp[i]);
        }

        return len - maxUpNum;
    }
}
