package com.netease.spring.demo.algorithm.leetcode701_800;

import com.netease.spring.demo.algorithm.leetcode1_100.Leetcode1;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author fangsida
 * @date 2020/12/26
 */
public class Leetcode773 {

    public int slidingPuzzle(int[][] board) {
        Set<String> visited = new HashSet<>();
        String start = convertToString(board);
        visited.add(start);
        String target = "123450";

        int[][] neighbor = new int[][]{{1,3,-1},{0,4,2},{1,5,-1},{0,4,-1},{3,1,5},{4,2,-1}};

        LinkedList<String> queue = new LinkedList<>();
        queue.offer(start);

        int step = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0;i<size;i++) {
                String cur = queue.poll();
                if (cur.equals(target)) {
                    return step;
                }

                int zeroIndex = 0;
                while (zeroIndex < cur.length()) {
                    if (cur.charAt(zeroIndex) == '0') {
                        break;
                    }
                    zeroIndex++;
                }

                for (int index : neighbor[zeroIndex]) {
                    if (index < 0) {
                        continue;
                    }

                    String next = swap(cur, index, zeroIndex);
                    if (!visited.contains(next)) {
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }
            step++;
        }

        return -1;
    }

    private String swap(String cur, int index, int zeroIndex) {
        char[] chars = cur.toCharArray();
        char temp = cur.charAt(index);
        chars[index] = chars[zeroIndex];
        chars[zeroIndex] = temp;
        return new String(chars);
    }

    private String convertToString(int[][] board){
        StringBuilder builder = new StringBuilder();
        for (int i=0;i<board.length;i++){
            for (int j = 0;j<board[0].length;j++){
                builder.append(board[i][j]);
            }
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{4,0,5}};
        Leetcode773 instance = new Leetcode773();
        int res = instance.slidingPuzzle(arr);
        System.out.println(res);
    }
}
