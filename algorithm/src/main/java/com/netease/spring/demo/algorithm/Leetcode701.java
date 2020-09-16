package com.netease.spring.demo.algorithm;

/**
 * @author fangsida
 * @date 2020/9/16
 */
public class Leetcode701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (null == root){
            return new TreeNode(val);
        }

        if (val < root.val){
            root.left =  insertIntoBST(root.left,val);
        }else if (val > root.val){
            root.right = insertIntoBST(root.right,val);
        }

        return root;
    }
}
