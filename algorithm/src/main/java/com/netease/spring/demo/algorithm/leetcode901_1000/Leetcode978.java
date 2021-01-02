package com.netease.spring.demo.algorithm.leetcode901_1000;

import com.netease.spring.demo.algorithm.Leetcode1219;

/**
 * @author fangsida
 * @date 2021/1/1
 */
public class Leetcode978 {

    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        Pair[] dp = new Pair[n];
        for (int i=0;i<n;i++){
            dp[i] = new Pair(1,1);
        }

        for (int i=1;i<n;i++){
            if (arr[i] > arr[i-1]){
                dp[i].up = dp[i-1].down+1;
            }else if (arr[i] < arr[i-1]){
                dp[i].down = dp[i-1].up+1;
            }
        }

        int res = Integer.MIN_VALUE;
        for (int i=0;i<n;i++){
            res = Math.max(res,dp[i].down);
            res = Math.max(res,dp[i].up);
        }

        return res;
    }

    private static class Pair{
        public int up;

        public int down;

        public Pair(int up, int down) {
            this.up = up;
            this.down = down;
        }
    }

    public static void main(String[] args) {
        Leetcode978 ins = new Leetcode978();
        int[] arr = {9,4,2,10,7,8,8,1,9};
        System.out.println(ins.maxTurbulenceSize(arr));
    }
}
