package com.netease.spring.demo.algorithm.leetcode401_500;

import com.netease.spring.demo.algorithm.TreeNode;

/**
 * @author fangsida
 * @date 2020/8/25
 */
public class Leetcode450 {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (null == root) {
            return root;
        }
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.right == null && root.left == null) {
                root = null;
            } else if (root.left != null) {
                root.val = predecessor(root).val;
                root.left = deleteNode(root.left, root.val);
            } else {
                root.val = successor(root).val;
                root.right = deleteNode(root.right, root.val);
            }
        }
        return root;
    }

    /**
     * 前置节点
     *
     * @param root
     * @return
     */
    private TreeNode predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null) {
            root = root.right;
        }

        return root;
    }

    /**
     * 后置节点
     *
     * @param root
     * @return
     */
    private TreeNode successor(TreeNode root) {
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }

        return root;
    }
}
