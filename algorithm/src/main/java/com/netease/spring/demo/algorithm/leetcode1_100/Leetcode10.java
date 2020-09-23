package com.netease.spring.demo.algorithm.leetcode1_100;

/**
 * @author fangsida
 * @date 2020/9/23
 */
public class Leetcode10 {

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;

        for (int i=0;i<m+1;i++){
            for (int j=1;j<n+1;j++){
                if (matches(s,p,i,j)){
                    dp[i][j] = dp[i-1][j-1];
                }else if (p.charAt(j-1) == '*'){
                    dp[i][j] = dp[i][j-2];
                    if (matches(s,p,i,j-1)){
                        dp[i][j] = dp[i][j] || dp[i-1][j];

                    }
                }else{
                    dp[i][j] = false;
                }
            }
        }

        return dp[m][n];
    }

    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

}
