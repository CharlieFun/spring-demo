package com.netease.spring.demo.algorithm.leetcode801_900;

import com.netease.spring.demo.algorithm.TreeNode;

/**
 * @author fangsida
 * @date 2020/9/17
 */
public class Leetcode897 {

    TreeNode cur;

    public TreeNode increasingBST(TreeNode root) {
        TreeNode node = new TreeNode(0);
        cur = node;
        inorder(root);
        return node.right;

    }

    private void inorder(TreeNode root) {
        if (null == root){
            return;
        }

        inorder(root.left);

        root.left = null;
        cur.right = root;
        cur = root;

        inorder(root.right);
    }
}
