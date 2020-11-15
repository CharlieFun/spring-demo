package com.netease.spring.demo.algorithm.leetcode1001_1100;

import com.netease.spring.demo.algorithm.TreeNode;

/**
 * @author fangsida
 * @date 2020/11/9
 */
public class Leetcode1038 {

    public TreeNode bstToGst(TreeNode root) {

        inorder(root);
        return root;
    }

    int sum = 0;

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.right);
        sum += root.val;
        root.val = sum;
        inorder(root.left);
    }
}
