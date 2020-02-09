package com.netease.spring.demo.algorithm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * 二叉树的中序遍历
 *
 * @author funstar
 * @date 2020/2/9
 */
public class Leetcode94 {
    //递归
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        return inorderTraversalHelper(root, res);
    }

    private List<Integer> inorderTraversalHelper(TreeNode root, List<Integer> res) {
        if (null == root) {
            return res;
        }

        inorderTraversalHelper(root.left, res);
        res.add(root.val);
        inorderTraversalHelper(root.right, res);
        return res;
    }

    //非递归
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while (null != cur || !stack.isEmpty()) {
            while (null != cur) {
                stack.add(cur);
            }

            TreeNode node = stack.pop();
            res.add(node.val);
            cur = node.right;
        }

        return res;
    }
}

