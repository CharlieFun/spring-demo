package com.netease.spring.demo.algorithm;

/**
 * @author fangsida
 * @date 2020/8/26
 */
public class Leetcode530 {

    int minDiff = Integer.MAX_VALUE;

    Integer pre = null;

    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return minDiff;
    }

    private void inOrder(TreeNode root) {
        if (null == root){
            return;
        }
        inOrder(root.left);

        if (null == pre){
            pre = root.val;
        }else{
            minDiff = Math.min(minDiff, root.val-pre);
            pre = root.val;
        }

        inOrder(root.right);

    }
}
