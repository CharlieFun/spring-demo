package com.netease.spring.demo.algorithm;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author funstar
 * @date 2020/2/8
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }


    public static TreeNode buildTree(Integer[] arr){
        TreeNode root = new TreeNode(arr[0]);

        Deque<TreeNode> deque  = new ArrayDeque<>();
        deque.offer(root);
        int i=0;
        while (!deque.isEmpty()){
            TreeNode node = deque.poll();
            i++;
            if (i<arr.length && null != arr[i]){
                TreeNode left = new TreeNode(arr[i]);
                node.left = left;
                deque.offer(left);
            }
            i++;
            if (i<arr.length && null != arr[i]){
                TreeNode right = new TreeNode(arr[i]);
                node.right = right;
                deque.offer(right);
            }
        }

        return root;
    }
}
