package com.netease.spring.demo.algorithm;

/**
 * @author fangsida
 * @date 2020/8/19
 */
public class Leetcode112 {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (null == root) {
            return false;
        }

        if (null == root.right && null == root.left) {
            if (root.val == sum) {
                return true;
            } else {
                return false;
            }
        }

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
