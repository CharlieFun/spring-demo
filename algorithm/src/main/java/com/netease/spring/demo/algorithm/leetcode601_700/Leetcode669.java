package com.netease.spring.demo.algorithm.leetcode601_700;

import com.netease.spring.demo.algorithm.TreeNode;

/**
 * @author fangsida
 * @date 2020/9/15
 */
public class Leetcode669 {

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }

        if (low <= root.val && root.val <= high) {
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
            return root;
        } else if (root.val < low) {
            return trimBST(root.right, low, high);
        } else {
            return trimBST(root.left, low, high);
        }
    }
}
