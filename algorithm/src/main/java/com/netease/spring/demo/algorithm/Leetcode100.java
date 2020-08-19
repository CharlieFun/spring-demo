package com.netease.spring.demo.algorithm;

/**
 * @author fangsida
 * @date 2020/8/18
 */
public class Leetcode100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (null == p && null == q){
            return true;
        }

        if (null == p || null == q){
            return false;
        }

        if (p.val != q.val){
            return false;
        }

        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
