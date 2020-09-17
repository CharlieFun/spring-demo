package com.netease.spring.demo.algorithm.leetcode1_100;

/**
 * https://leetcode-cn.com/problems/word-search
 * 单词搜索
 * 思路：回溯法，通过mark[m][n]来记录足迹保证每个只使用一次
 *
 * @author fangsida
 * @date 2020/2/15
 */
public class Leetcode79 {

    private boolean[][] marked;

    //        x-1,y
    // x,y-1  x,y    x,y+1
    //        x+1,y
    private int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    // 盘面上有多少行
    private int m;

    // 盘面上有多少列
    private int n;

    private String word;

    private char[][] board;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        if (m == 0) {
            return false;
        }
        n = board[0].length;
        if (n == 0) {
            return false;
        }

        marked = new boolean[m][n];
        this.word = word;
        this.board = board;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(int i, int j, int start) {
        if (start == word.length() - 1) {
            return board[i][j] == word.charAt(start);
        }

        if (board[i][j] == word.charAt(start)) {
            marked[i][j] = true;
            for (int k = 0; k < 4; k++) {
                int newX = i + direction[k][0];
                int newY = j + direction[k][1];
                if (inArea(newX, newY) && !marked[newX][newY]) {
                    if (dfs(newX, newY, start + 1)) {
                        return true;
                    }
                }
            }
            marked[i][j] = false;
        }

        return false;
    }

    private boolean inArea(int newX, int newY) {
        return newX > -1 && newX < m && newY > -1 && newY < n;
    }

}
