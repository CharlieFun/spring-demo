package com.netease.spring.demo.algorithm.leetcode401_500;

/**
 * @author fangsida
 * @date 2020/3/22
 */
public class Leetcode461 {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int distance = 0;
        while (xor != 0) {
            if (xor % 2 == 1)
                distance += 1;
            xor = xor >> 1;
        }
        return distance;
    }

}
