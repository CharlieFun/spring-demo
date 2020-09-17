package com.netease.spring.demo.algorithm.leetcode101_200;

import com.netease.spring.demo.algorithm.TreeNode;

import java.util.*;

/**
 * @author fangsida
 * @date 2020/8/19
 */
public class Leetcode107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (null == root){
            return res;
        }

        Deque<List<Integer>> stack = new ArrayDeque<>();
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);

        while (!nodes.isEmpty()){
            int size = nodes.size();
            List<Integer> values = new ArrayList<>();

            while (size > 0){
                TreeNode node = nodes.poll();
                values.add(node.val);

                if(node.left != null){
                    nodes.offer(node.left);
                }
                if (node.right != null){
                    nodes.offer(node.right);
                }
                size--;
            }

            stack.push(values);
        }

        while (!stack.isEmpty()){
            res.add(stack.pop());
        }

        return res;
    }
}
