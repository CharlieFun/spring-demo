package com.netease.spring.demo.algorithm.leetcode101_200;

import java.util.List;

/**
 * @author fangsida
 * @date 2020/9/26
 */
public class Leetcode120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }

        int row = triangle.size();
        int[][] dp = new int[triangle.size()][triangle.get(row-1).size()];
        for (int i = 0; i < triangle.get(0).size(); i++) {
            dp[0][i] = triangle.get(0).get(i);
        }

        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                } else if (j == triangle.get(i).size() - 1) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
                }
            }


        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < triangle.get(row - 1).size(); i++) {
            res = Math.min(res, dp[row - 1][i]);
        }

        return res;
    }


    //压缩
    public int minimumTotal2(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] f = new int[n];
        f[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; ++i) {
            for (int j = i; j >=0; j--) {
                if (j == i){
                    f[i] = f[i - 1] + triangle.get(i).get(i);
                }else if (j == 0){
                    f[0] = f[0] + triangle.get(i).get(0);
                }else{
                    f[j] = Math.min(f[j - 1], f[j]) + triangle.get(i).get(j);
                }
            }
        }
        int minTotal = f[0];
        for (int i = 1; i < n; ++i) {
            minTotal = Math.min(minTotal, f[i]);
        }
        return minTotal;
    }


}
