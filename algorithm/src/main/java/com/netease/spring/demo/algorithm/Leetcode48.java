package com.netease.spring.demo.algorithm;

/**
 * https://leetcode-cn.com/problems/rotate-image/solution/xuan-zhuan-tu-xiang-by-leetcode/
 * 旋转图像
 *
 * @author fangsida
 * @date 2020/2/15
 */
public class Leetcode48 {

    /**
     * 先对矩阵转置，然后按列对称交换
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][len - j - 1];
                matrix[i][len - j - 1] = temp;
            }
        }
    }
}
