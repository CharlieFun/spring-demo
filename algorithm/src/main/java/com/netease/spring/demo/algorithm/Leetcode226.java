package com.netease.spring.demo.algorithm;

/**
 * https://leetcode-cn.com/problems/invert-binary-tree/
 * 翻转二叉树
 * @author fangsida
 * @date 2020/2/16
 */
public class Leetcode226 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return root;
        }

        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left = right;
        root.right = left;

        return root;
    }
}
