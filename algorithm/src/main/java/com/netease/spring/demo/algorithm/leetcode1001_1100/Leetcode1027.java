package com.netease.spring.demo.algorithm.leetcode1001_1100;

/**
 * @author fangsida
 * @date 2021/1/2
 */
public class Leetcode1027 {

    public int longestArithSeqLength(int[] A) {
        int N = A.length;
        int[][] dp = new int[N][20000];
        int ans = 2;
        for (int i=0;i<N;i++){
            for (int j = 0;j<20000;j++){
                dp[i][j] = 1;
            }
        }
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < i; ++j) {
                int diff = A[i] - A[j] + 10000;
                dp[i][diff] = Math.max(dp[i][diff], dp[j][diff] + 1);
                ans = Math.max(ans, dp[i][diff]);
            }
        }

        return ans;

    }

    public static void main(String[] args) {
        Leetcode1027 ins = new Leetcode1027();
        int[] arr = {3,6,9,12};
        System.out.println(ins.longestArithSeqLength(arr));
    }
}
