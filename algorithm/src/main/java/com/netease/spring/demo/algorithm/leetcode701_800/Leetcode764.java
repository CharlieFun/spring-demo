package com.netease.spring.demo.algorithm.leetcode701_800;

/**
 * 作者：sakuragi1111
 * 链接：https://leetcode-cn.com/problems/largest-plus-sign/solution/javadong-tai-gui-hua-jian-dan-yi-dong-by-dan-huang/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @author fangsida
 * @date 2020/11/8
 */
public class Leetcode764 {
    public int orderOfLargestPlusSign(int N, int[][] A) {
        int[][][] dp = new int[N][N][4];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 4; k++) dp[i][j][k] = 1;
            }
        }
        for (int[] z : A) {
            for (int k = 0; k < 4; k++) dp[z[0]][z[1]][k] = 0;
        }
        // one-pass算左和上
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                if (dp[i][j][0] == 0) {
                    continue;
                }
                dp[i][j][0] = 1 + dp[i][j - 1][0];
                dp[i][j][1] = 1 + dp[i - 1][j][1];
            }
        }
        // one-pass算右和下
        for (int i = N - 2; i >= 0; i--) {
            for (int j = N - 2; j >= 0; j--) {
                if (dp[i][j][2] == 0) {
                    continue;
                }
                dp[i][j][2] = 1 + dp[i][j + 1][2];
                dp[i][j][3] = 1 + dp[i + 1][j][3];
            }
        }
        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int k = min(dp[i][j][0], dp[i][j][1], dp[i][j][2], dp[i][j][3]);
                ans = Math.max(ans, k);
            }
        }
        return ans;
    }

    int min(int a, int b, int c, int d) {
        return Math.min(Math.min(a, b), Math.min(c, d));
    }


}
