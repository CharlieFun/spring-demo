package com.netease.spring.demo.algorithm;

/**
 * 找到最大上升序列
 * <p>
 * [
 * [9,9,5],
 * [6,8,7],
 * [4,1,6]
 * ]
 * <p>
 * 答案：[1，6，7，8，9]，输出5
 *
 * @author fangsida
 * @date 2020/12/13
 */
public class ByteDance1 {

    int[][] dict = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    int m;

    int n;

    boolean[][] visited;

    int[][] dp;

    int res = 1;

    public static void main(String[] args) {
        int[][] arr = new int[][]{{9, 9, 5}, {6, 8, 7}, {4, 1, 6}};

        ByteDance1 byteDance1 = new ByteDance1();
        System.out.println(byteDance1.lengthOfLIS(arr));
    }

    public int lengthOfLIS(int[][] nums) {
        m = nums.length;
        n = nums[0].length;
        dp = new int[m][n];
        visited = new boolean[m][n];

        //初始化
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = 1;
            }
        }

        //计算dp
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(nums, i, j);
            }
        }

        //计算结果
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res,dp[i][j]);
            }
        }

        return res;


    }

    private int dfs(int[][] nums, int x, int y) {
        if (visited[x][y]){
            return dp[x][y];
        }

        int len = dp[x][y];
        for (int k = 0; k < 4; k++) {
            int xx = x + dict[k][0];
            int yy = y + dict[k][1];
            if (xx < 0 || yy < 0 || xx >= m || yy >= n) {
                continue;
            }
            if (nums[x][y] <= nums[xx][yy]) {
                continue;
            }
            if (!visited[xx][yy]) {
                len = Math.max(len, dfs(nums, xx, yy)+1);
            } else {
                len = Math.max(len, dp[xx][yy]+1);
            }
        }

        dp[x][y] = len;
        visited[x][y] = true;
        return len;
    }
}
