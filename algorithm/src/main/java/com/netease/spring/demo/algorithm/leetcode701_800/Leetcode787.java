package com.netease.spring.demo.algorithm.leetcode701_800;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fangsida
 * @date 2020/11/8
 */
public class Leetcode787 {

    int ans = -1;

    public static void main(String[] args) {
        Leetcode787 instance = new Leetcode787();
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};

        System.out.println(instance.findCheapestPrice(3, flights, 0, 2, 1));
    }

    /**
     * 自己的回溯法，超时了
     *
     * @param n
     * @param flights
     * @param src
     * @param dst
     * @param K
     * @return
     */
    public int findCheapestPrice_0(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        int maxNum = 0;
        for (int[] flight : flights) {
            if (!map.containsKey(flight[0])) {
                List<int[]> list = new ArrayList<>();
                map.put(flight[0], list);
            }
            map.get(flight[0]).add(flight);
            maxNum = Math.max(maxNum, flight[0]);
            maxNum = Math.max(maxNum, flight[1]);
        }
        boolean[] used = new boolean[maxNum + 1];

        backTrack(map, src, dst, -1, K, 0, used);

        return ans;
    }

    private void backTrack(Map<Integer, List<int[]>> map, int src, int dst,
                           int transfer, int maxTransfer, int cost,
                           boolean[] used) {
        if (src == dst && transfer <= maxTransfer) {
            if (ans < 0) {
                ans = cost;
            } else {
                ans = Math.min(ans, cost);
            }

            return;
        }

        if (transfer > maxTransfer) {
            return;
        }

        if (map.get(src) == null) {
            return;
        }

        for (int[] flight : map.get(src)) {
            if (used[flight[0]]) {
                continue;
            }

            used[flight[0]] = true;
            backTrack(map, flight[1], dst, transfer + 1, maxTransfer, cost + flight[2], used);
            used[flight[0]] = false;
        }
    }

    //参考：https://leetcode-cn.com/problems/cheapest-flights-within-k-stops/solution/dp-by-sunnywanggithub/
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        //dp[k][d]表示经过k次转机后到达d的最小花费

        int[][] dp = new int[K + 1][n];

        //初始化dp[0][d]
        for (int i = 0; i <= K; i++) {
            for (int j=0;j<n;j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int[] flight : flights) {
            if (flight[0] == src) {
                dp[0][flight[1]] = flight[2];
            }
        }

        for (int k = 1; k <= K; k++) {
            for (int[] flight : flights) {
                if (dp[k - 1][flight[0]] == Integer.MAX_VALUE) {
                    continue;
                } else {
                    dp[k][flight[1]] = Math.min(dp[k][flight[1]], dp[k - 1][flight[0]] + flight[2]);
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int k = 0; k <= K; k++) {
            if (dp[k][dst] == -1) {
                continue;
            } else {
                ans = Math.min(ans, dp[k][dst]);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
