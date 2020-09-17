package com.netease.spring.demo.algorithm.leetcode501_600;

import com.netease.spring.demo.algorithm.TreeNode;

import java.util.Stack;

/**
 * @author fangsida
 * @date 2020/8/27
 */
public class Leetcode538 {

    public TreeNode convertBST(TreeNode root) {
        int sum = 0;
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (!stack.isEmpty() || node != null) {
            /* push all nodes up to (and including) this subtree's maximum on
             * the stack. */
            while (node != null) {
                stack.add(node);
                node = node.right;
            }

            node = stack.pop();
            sum += node.val;
            node.val = sum;

            /* all nodes with values between the current and its parent lie in
             * the left subtree. */
            node = node.left;
        }

        return root;
    }



}
