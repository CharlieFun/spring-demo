package com.netease.spring.demo.algorithm;

/**
 * @author fangsida
 * @date 2020/8/17
 */
public class Leetcode951 {

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (null == root1 && null == root2) {
            return true;
        }

        if (null == root1 || null == root2) {
            return false;
        }

        if (root1.val != root2.val) {
            return false;
        }

        return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right))
                || (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
    }
}
