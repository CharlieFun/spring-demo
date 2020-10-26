package com.netease.spring.demo.algorithm.leetcode601_700;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author fangsida
 * @date 2020/10/26
 */
public class Leetcode646 {

    public static void main(String[] args) {
        int[][] pairs = {{3, 2}, {2, 3}, {5, 4}, {1, 2}};
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] A, int[] B) {//按数对里前面的那个数排序
                if (A[0] > B[0]) {
                    return 1;
                } else if (A[0] < B[0]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        System.out.println(pairs);
    }

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] A, int[] B) {//按数对里前面的那个数排序
                if (A[0] > B[0]) {
                    return 1;
                } else if (A[0] < B[0]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        int res = 1;
        int[] dp = new int[pairs.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < pairs.length; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            res = Math.max(res, dp[i]);
        }


        return res;
    }
}
