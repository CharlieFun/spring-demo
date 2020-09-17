package com.netease.spring.demo.algorithm.leetcode901_1000;

import com.netease.spring.demo.algorithm.TreeNode;

/**
 * @author fangsida
 * @date 2020/9/18
 */
public class Leetcode938 {

    int sum = 0;

    public int rangeSumBST(TreeNode root, int L, int R) {
        helper(root, L, R);
        return sum;
    }

    private void helper(TreeNode root, int l, int r) {
        if (null == root) {
            return;
        }

        if (l <= root.val && root.val <= r) {
            sum += root.val;
        }

        if (l <= root.val) {
            helper(root.left, l, r);
        }
        if (r >= root.val) {
            helper(root.right, l, r);
        }
    }
}
