package com.netease.spring.demo.algorithm.leetcode1001_1100;

/**
 * @author fangsida
 * @date 2020/11/21
 */
public class Leetcode1079 {

    public static void main(String[] args) {
        int[] arr = new int[3];
        arr[1]++;
        System.out.println(arr);
    }

    public int numTilePossibilities(String tiles) {
        int[] arr = new int[26];
        for (char ch : tiles.toCharArray()) {
            arr[ch - 'A']++;
        }

        return dfs(arr);
//        return 0;
    }

    private int dfs(int[] arr) {
        int res = 0;
        for (int i = 0; i < 26; i++) {
            if (arr[i] == 0) {
                continue;
            }

            res++;
            arr[i]--;
            res += dfs(arr);
            arr[i]++;
        }
        return res;
    }
}
