package com.netease.spring.demo.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author fangsida
 * @date 2020/8/23
 */
public class Leetcode199 {

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();

        if (null == root) {
            return res;
        }

        queue.addFirst(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            res.add(queue.peek().val);

            while (size > 0) {
                TreeNode node = queue.pop();
                if (node.right != null) {
                    queue.addLast(node.right);
                }
                if (node.left != null) {
                    queue.addLast(node.left);
                }

                size--;
            }
        }

        return res;
    }
}
