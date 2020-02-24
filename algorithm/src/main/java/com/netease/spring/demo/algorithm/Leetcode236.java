package com.netease.spring.demo.algorithm;

/**
 * 二叉树的最近公共祖先
 * @author fangsida
 * @date 2020/2/23
 */
public class Leetcode236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root ==  null || root == p || root == q){
            return root;
        }

        TreeNode left = this.lowestCommonAncestor(root.left, p,q);
        if (left != null && left != p && left != q){
            return left;
        }

        TreeNode right = this.lowestCommonAncestor(root.right,p,q);
        if(left != null && right != null){
            return root;
        }else{
            return left != null ? left : right;
        }
    }
}
