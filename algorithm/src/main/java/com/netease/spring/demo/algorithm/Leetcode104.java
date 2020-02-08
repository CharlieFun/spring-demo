package com.netease.spring.demo.algorithm;

/**
 * @author funstar
 * @date 2020/2/8
 */
public class Leetcode104 {
    public int maxDepth(TreeNode root) {
        if (null == root){
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }
}
