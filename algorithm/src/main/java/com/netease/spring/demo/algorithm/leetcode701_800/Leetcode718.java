package com.netease.spring.demo.algorithm.leetcode701_800;

/**
 * @author fangsida
 * @date 2020/11/8
 */
public class Leetcode718 {

    public int findLength(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int[][] dp = new int[m+1][n+1];

        int ans = 0;
        for (int i=1;i<m+1;i++){
            for (int j=1;j<n+1;j++){
                if (A[i-1] == B[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                    ans = Math.max(ans,dp[i][j]);
                }else{
                    dp[i][j]=0;
                }

            }
        }

        return ans;
    }
}
