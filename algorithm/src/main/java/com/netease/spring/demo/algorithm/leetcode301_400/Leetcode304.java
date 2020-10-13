package com.netease.spring.demo.algorithm.leetcode301_400;

/**
 * @author fangsida
 * @date 2020/10/12
 */
public class Leetcode304 {

    class NumMatrix {

        int m;

        int n;

        int[][] cache;

        public NumMatrix(int[][] matrix) {
            m = matrix.length;

            if (m == 0) {
                return;
            }
            n = matrix[0].length;
            cache = new int[m + 1][n + 1];

            if (m != 0 && n != 0) {
                for (int i = 1; i < m + 1; i++) {
                    for (int j = 1; j < n + 1; j++) {
                        cache[i][j] = cache[i - 1][j] + cache[i][j - 1] - cache[i - 1][j - 1] + matrix[i - 1][j - 1];
                    }
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (m == 0 || n == 0) {
                return 0;
            }
            return cache[row2 + 1][col2 + 1] - cache[row1][col2 + 1] - cache[row2 + 1][col1]
                    + cache[row1][col1];
        }
    }
}
