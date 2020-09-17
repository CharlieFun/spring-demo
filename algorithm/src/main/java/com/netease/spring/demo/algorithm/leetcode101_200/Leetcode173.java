package com.netease.spring.demo.algorithm.leetcode101_200;

import com.netease.spring.demo.algorithm.TreeNode;

import java.util.ArrayDeque;

/**
 * @author fangsida
 * @date 2020/8/16
 */
public class Leetcode173 {

    public static class BSTIterator {

        ArrayDeque<TreeNode> deque;

        public BSTIterator(TreeNode root) {
            deque = new ArrayDeque<>();

            //二叉树的中序遍历
            midVisit(root, deque);
        }

        private void midVisit(TreeNode root, ArrayDeque<TreeNode> deque) {
            if (null == root) {
                return;
            }

            midVisit(root.left, deque);
            deque.offer(root);
            midVisit(root.right, deque);

        }

        /**
         * @return the next smallest number
         */
        public int next() {
            return deque.poll().val;
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return !deque.isEmpty();
        }
    }
}
