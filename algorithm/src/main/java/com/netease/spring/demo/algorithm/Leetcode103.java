package com.netease.spring.demo.algorithm;

import java.util.*;

/**
 * @author fangsida
 * @date 2020/8/18
 */
public class Leetcode103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (null == root) {
            return res;
        }

        Deque<TreeNode> treeNodeDeque = new ArrayDeque<>();
        treeNodeDeque.addFirst(root);
        visit(res, treeNodeDeque, true);
        return res;
    }

    private void visit(List<List<Integer>> res, Deque<TreeNode> curList, boolean asc) {
        if (null == curList || curList.isEmpty()) {
            return;
        }

        Deque<TreeNode> nextList = new ArrayDeque<>();
        LinkedList<Integer> values = new LinkedList<>();

        while (!curList.isEmpty()) {
            TreeNode node = curList.removeFirst();

            if (asc) {
                values.addLast(node.val);
            } else {
                values.addFirst(node.val);
            }

            if (node.left != null) {
                nextList.addLast(node.left);
            }

            if (node.right != null) {
                nextList.addLast(node.right);
            }
        }


        res.add(values);
        visit(res, nextList, !asc);
    }
}
