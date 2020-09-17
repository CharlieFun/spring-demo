package com.netease.spring.demo.algorithm.leetcode601_700;

import com.netease.spring.demo.algorithm.TreeNode;

/**
 * @author fangsida
 * @date 2020/9/15
 */
public class Leetcode671 {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        return help(root, root.val);
    }

    private int help(TreeNode root, int min) {
        if (root == null) return -1;
        if (root.val > min) return root.val;
        int left = help(root.left, min);
        int right = help(root.right, min);
        if (left == -1) return right;
        if (right == -1) return left;
        return Math.min(left, right);
    }
}
