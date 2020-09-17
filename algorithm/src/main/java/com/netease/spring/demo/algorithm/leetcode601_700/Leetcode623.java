package com.netease.spring.demo.algorithm.leetcode601_700;

import com.netease.spring.demo.algorithm.TreeNode;

import java.util.LinkedList;

/**
 * @author fangsida
 * @date 2020/8/29
 */
public class Leetcode623 {

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (null == root){
            return null;
        }

        if (d == 1){
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int hight = 0;
        while (!queue.isEmpty()){
            hight++;

            int size = queue.size();
            while (size>0){
                TreeNode node = queue.poll();


                if (node.left != null){
                    queue.add(node.left);
                }

                if (node.right != null){
                    queue.add(node.right);
                }

                if (hight == (d-1)){
                    TreeNode left = new TreeNode(v);
                    TreeNode right = new TreeNode(v);
                    left.left = node.left;
                    node.left = left;

                    right.right = node.right;
                    node.right = right;
                }

                size--;
            }

        }

        return root;
    }
}
