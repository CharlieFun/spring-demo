package com.netease.spring.demo.algorithm;

import java.util.LinkedList;

/**
 * @author fangsida
 * @date 2020/2/16
 */
public class Leetcode200 {

    private int rows;

    private int cols;

    private boolean[][] marked;

    //        x-1,y
    // x,y-1  x,y    x,y+1
    //        x+1,y
    private int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};


    //题解：https://leetcode-cn.com/problems/number-of-islands/solution/dfs-bfs-bing-cha-ji-python-dai-ma-java-dai-ma-by-l/
    public int numIslands(char[][] grid) {
        int ans = 0;

        rows = grid.length;
        if (rows == 0) {
            return 0;
        }

        cols = grid[0].length;
        marked = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && !marked[i][j]) {
                    ans++;
                    LinkedList<Integer> queue = new LinkedList<>();
                    queue.addLast(i * cols + j);
                    marked[i][j] = true;
                    while (!queue.isEmpty()) {
                        int cur = queue.removeFirst();
                        int x = cur / cols;
                        int y = cur % cols;
                        for (int k = 0; k < 4; k++) {
                            int newX = x + direction[k][0];
                            int newY = y + direction[k][1];
                            if (inArea(newX, newY) && grid[newX][newY] == '1' && !marked[newX][newY]) {
                                marked[newX][newY] = true;
                                queue.addLast(newX * cols + newY);
                            }
                        }
                    }
                }
            }
        }

        return ans;
    }

    private boolean inArea(int newX, int newY) {
        return newX > -1 && newX < rows && newY > -1 && newY < cols;
    }


}
