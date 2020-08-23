package com.netease.spring.demo.algorithm;

/**
 * @author fangsida
 * @date 2020/8/23
 */
public class Leetcode222 {
    public int countNodes(TreeNode root) {
        if (root == null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if (leftHeight == rightHeight){
            return (1<<leftHeight) + countNodes(root.right);
        }else{
            return (1<<rightHeight) + countNodes(root.left);
        }

    }

    private int height(TreeNode root) {
        if (root == null){
            return 0;
        }

        return Math.max(height(root.left),height(root.right))+1;
    }


    public static void main(String[] args){
        System.out.println(1<<1);
    }

}
