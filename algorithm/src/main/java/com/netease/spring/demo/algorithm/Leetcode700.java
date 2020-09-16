package com.netease.spring.demo.algorithm;

/**
 * @author fangsida
 * @date 2020/9/16
 */
public class Leetcode700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || val == root.val) return root;

        return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);
    }

}
