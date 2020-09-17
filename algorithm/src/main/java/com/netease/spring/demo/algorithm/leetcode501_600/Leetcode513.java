package com.netease.spring.demo.algorithm.leetcode501_600;

import com.netease.spring.demo.algorithm.TreeNode;

import java.util.LinkedList;

/**
 * @author fangsida
 * @date 2020/8/26
 */
public class Leetcode513 {
    public int findBottomLeftValue(TreeNode root) {
        int res=0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if (i==0){
                    res = node.val;
                }

                if (null != node.left ) {
                    queue.add(node.left);
                }
                if (null != node.right ) {
                    queue.add(node.right);
                }
            }
        }

        return res;
    }
}
