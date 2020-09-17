package com.netease.spring.demo.algorithm.leetcode401_500;

import com.netease.spring.demo.algorithm.TreeNode;

/**
 * @author fangsida
 * @date 2020/8/23
 */
public class Leetcode404 {
    int sum = 0;


    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null){
            return sum;
        }
        help(root.left,true);
        help(root.right,false);
        return sum;
    }

    private void help(TreeNode root, boolean isLeft) {

        if (root == null){
            return;
        }

        if (root.left == null && root.right == null && isLeft){
            sum += root.val;
        }

        help(root.left,true);
        help(root.right,false);
    }
}
