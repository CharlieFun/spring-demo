package com.netease.spring.demo.algorithm.leetcode1_100;

/**
 * https://leetcode-cn.com/problems/unique-binary-search-trees/
 * 不同的二叉搜索树
 *
 * @author funstar
 * @date 2020/2/9
 */
public class Leetcode96 {

    public int numTrees(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            int left = numTrees(i - 1);
            int right = numTrees(n - i);
            left = 0 == left ? 1 : left;
            right = 0 == right ? 1 : right;
            res += left * right;
        }

        return res;

    }

    public static void main(String[] args) {
        Leetcode96 ins = new Leetcode96();
        System.out.println(ins.numTrees(3));
    }

}
