package com.netease.spring.demo.algorithm.leetcode501_600;

import com.netease.spring.demo.algorithm.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author fangsida
 * @date 2020/8/26
 */
public class Leetcode515 {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (null == root){
            return list;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        int curMax = Integer.MIN_VALUE;
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if (node.val > curMax){
                    curMax = node.val;
                }

                if (null != node.left ) {
                    queue.add(node.left);
                }
                if (null != node.right ) {
                    queue.add(node.right);
                }
            }
            list.add(curMax);
            curMax = Integer.MIN_VALUE;
        }

        return list;
    }
}
