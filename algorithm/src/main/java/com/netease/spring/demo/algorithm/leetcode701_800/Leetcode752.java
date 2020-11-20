package com.netease.spring.demo.algorithm.leetcode701_800;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author fangsida
 * @date 2020/11/17
 */
public class Leetcode752 {
    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");

        int distance = 0;

        Set<String> visited = new HashSet<>();
        for (String s : deadends) {
            visited.add(s);
        }
        if (visited.contains("0000")){
            return -1;
        }

        visited.add("0000");

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();

                if (cur.equals(target)) {
                    return distance;
                }

                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if (!visited.contains(up)) {
                        queue.offer(up);
                        visited.add(up);
                    }

                    String down = minusOne(cur, j);
                    if (!visited.contains(down)) {
                        queue.offer(down);
                        visited.add(down);
                    }
                }
            }

            distance++;
        }

        return -1;
    }

    private static String minusOne(String cur, int j) {
        int num = Integer.parseInt(String.valueOf(cur.charAt(j)));

        if (num == 0) {
            num = 9;
        } else {
            num -= 1;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < cur.length(); i++) {
            if (i == j) {
                builder.append(num);
            } else {
                builder.append(cur.charAt(i));
            }
        }

        return builder.toString();
    }

    private static String plusOne(String cur, int j) {
        int num = Integer.parseInt(String.valueOf(cur.charAt(j)));

        if (num == 9) {
            num = 0;
        } else {
            num += 1;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < cur.length(); i++) {
            if (i == j) {
                builder.append(num);
            } else {
                builder.append(cur.charAt(i));
            }
        }

        return builder.toString();
    }

}
