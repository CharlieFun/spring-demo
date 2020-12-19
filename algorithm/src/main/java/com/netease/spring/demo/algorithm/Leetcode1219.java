package com.netease.spring.demo.algorithm;

/**
 * @author fangsida
 * @date 2020/11/22
 */
public class Leetcode1219 {

    int[][] dict = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int res = Integer.MIN_VALUE;

    public int getMaximumGold(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
//        int[][] gold = new int[m][n];
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (valid(grid,visited,i,j)) {
                    dfs(grid, visited, i, j,0);
                }
            }
        }
        return res;
    }

    private void dfs(int[][] grid, boolean[][] visited, int row, int col,int sum) {
        sum += grid[row][col];
        visited[row][col] = true;
        res = Math.max(res,sum);


        for (int i = 0; i < 4; i++) {
            int newRow = row + dict[i][0];
            int newCol = col + dict[i][1];
            if (!valid(grid, visited, newRow, newCol)) {
                continue;
            }

            dfs(grid, visited, newRow, newCol, sum);

        }

        sum -= grid[row][col];
        visited[row][col] = false;

    }

    private boolean valid(int[][] grid, boolean[][] visited, int row, int col) {
        if (row >= grid.length || row < 0
                || col >= grid[0].length || col < 0
                || visited[row][col]
                || grid[row][col] == 0) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,6,0},{5,8,7},{0,9,0}};
        boolean[][] visited = new boolean[3][3];
        Leetcode1219 ins = new Leetcode1219();
        ins.dfs(grid,visited,0,1,0);
    }
}
