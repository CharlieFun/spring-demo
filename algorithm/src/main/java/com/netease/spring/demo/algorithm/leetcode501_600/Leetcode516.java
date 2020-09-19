package com.netease.spring.demo.algorithm.leetcode501_600;

/**
 * 参考：https://labuladong.gitbook.io/algo/dong-tai-gui-hua-xi-lie/zi-xu-lie-wen-ti-mo-ban
 *
 * @author fangsida
 * @date 2020/9/19
 */
public class Leetcode516 {

    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        //dp数组含义：
        // dp[i][j]: s下标从i到j的最长回文子序列的长度
        //题目的问题相当于求dp[0][len-1]的值
        int[][] dp = new int[len][len];

        //初始化，i=j时dp[i][j]=1
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }

        //循环填充dp，方向：
        // i：len-1 ->0
        //j :0->len-1
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][len - 1];
    }

    public static void main(String[] args) {
        int[][] arr = new int[2][2];
        System.out.println(arr[1][1]);
    }
}
