package com.netease.spring.demo.algorithm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author fangsida
 * @date 2020/8/21
 */
public class Leetcode144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (null == root){
            return res;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.push(root);

        while (!queue.isEmpty()){
            TreeNode node = queue.pop();
            res.add(node.val);
            if (node.right != null){
                queue.push(node.right);
            }
            if (node.left != null){
                queue.push(node.left);
            }
        }

        return res;
    }
}
