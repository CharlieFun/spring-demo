package com.netease.spring.demo.algorithm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author fangsida
 * @date 2020/8/16
 */
public class Leetcode1367 {

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (null == head) {
            return true;
        }

        if (null == root) {
            return false;
        }

        //层序遍历一遍，找头结点
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();

            if (treeNode.val == head.val) {
                if (matchPath(head, treeNode)) {
                    return true;
                }
            }

            if (null != treeNode.left) {
                stack.push(treeNode.left);
            }

            if (null != treeNode.right) {
                stack.push(treeNode.right);
            }
        }

        return false;
    }

    private boolean matchPath(ListNode head, TreeNode root) {
        if (null == head) {
            return true;
        }

        if (null == root) {
            return false;
        }

        if (head.val == root.val) {
            return matchPath(head.next, root.left) || matchPath(head.next, root.right);
        } else {
            return false;
        }
    }
}
