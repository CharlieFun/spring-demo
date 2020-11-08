package com.netease.spring.demo.algorithm.leetcode601_700;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 作者：LeetCode
 * 链接：https://leetcode-cn.com/problems/knight-probability-in-chessboard/solution/ma-zai-qi-pan-shang-de-gai-lu-by-leetcode/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author fangsida
 * @date 2020/11/1
 */
public class Leetcode688 {
    public double knightProbability(int N, int K, int sr, int sc) {
        double[][] dp = new double[N][N];
        int[] dr = new int[]{2, 2, 1, 1, -1, -1, -2, -2};
        int[] dc = new int[]{1, -1, 2, -2, 2, -2, 1, -1};

        dp[sr][sc] = 1;
        for (; K > 0; K--) {
            double[][] dp2 = new double[N][N];
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    for (int k = 0; k < 8; k++) {
                        int cr = r + dr[k];
                        int cc = c + dc[k];
                        if (0 <= cr && cr < N && 0 <= cc && cc < N) {
                            dp2[cr][cc] += dp[r][c] / 8.0;
                        }
                    }
                }
            }
            dp = dp2;
        }
        double ans = 0.0;
        for (double[] row: dp) {
            for (double x: row) ans += x;
        }
        return ans;
    }


}
