package com.netease.spring.demo.algorithm.tree;

import com.netease.spring.demo.algorithm.TreeNode;

import java.util.Stack;

/**
 * @author fangsida
 * @date 2020/9/17
 */
public class PreOrderTraverse {

    //递归实现
    public void preOrderTraverse1(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + "->");
            preOrderTraverse1(root.left);
            preOrderTraverse1(root.right);
        }
    }

    //非递归实现
    public void preOrderTraverse2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.empty()) {
            if (node != null) {
                System.out.print(node.val + "->");
                stack.push(node);
                node = node.left;
            } else {
                TreeNode tem = stack.pop();
                node = tem.right;
            }
        }
    }
}
