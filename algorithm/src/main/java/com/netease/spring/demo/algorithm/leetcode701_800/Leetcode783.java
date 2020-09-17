package com.netease.spring.demo.algorithm.leetcode701_800;

import com.netease.spring.demo.algorithm.TreeNode;

import java.util.LinkedList;

/**
 * @author fangsida
 * @date 2020/9/16
 */
public class Leetcode783 {
    TreeNode pre;

    int ans = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        //非递归实现
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;


            }
            if (!stack.isEmpty()) {
                node = stack.pop();

                if (pre == null) {
                    pre = node;
                } else {
                    ans = Math.min(ans, node.val - pre.val);
                    pre = node;
                }

                node = node.right;
            }
        }

        return ans;
    }
}
