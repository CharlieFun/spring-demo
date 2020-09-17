package com.netease.spring.demo.algorithm.leetcode101_200;

import com.netease.spring.demo.algorithm.TreeNode;

import java.util.*;

/**
 * @author fangsida
 * @date 2020/8/21
 */
public class Leetcode145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (null == root) {
            return res;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.pop();
            res.addFirst(node.val);
            if (node.left != null) {
                queue.push(node.left);
            }
            if (node.right != null) {
                queue.push(node.right);
            }

        }

        return res;
    }

}
