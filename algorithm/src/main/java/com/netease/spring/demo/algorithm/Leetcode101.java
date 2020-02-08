package com.netease.spring.demo.algorithm;

/**
 * @author funstar
 * @date 2020/2/8
 */
public class Leetcode101 {

    public boolean isSymmetric(TreeNode root) {
        if (null == root) {
            return false;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;

        return isMirror(left, right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left != null && right != null) {
            if (left.val != right.val) {
                return false;
            }else{
                return isMirror(left.left,right.right) && isMirror(left.right,right.left);
            }
        }else{
            return false;
        }


    }
}
