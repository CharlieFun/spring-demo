package com.netease.spring.demo.algorithm;

/**
 * @author fangsida
 * @date 2020/8/17
 */
public class Leetcode437 {

    public int pathSum(TreeNode root, int sum) {
        return pathSum(root,sum,true) + pathSum(root,sum,false);
    }

    public int pathSum(TreeNode root, int sum, boolean self) {
        if (null == root){
            return 0;
        }

        int count = 0;
        if (root.val == sum){
            count = 1;
        }

        if (self){
            return pathSum(root.left,sum-root.val,true)+pathSum(root.right,sum-root.val,true) + count;
        }else{
            return pathSum(root.left,sum) + pathSum(root.right,sum);
        }

    }


    public static void main(String[] args) {
        Integer[] arr = new Integer[]{10,5,-3,3,2,null,11,3,-2,null,1};
        TreeNode root = TreeNode.buildTree(arr);

        Leetcode437 instance = new Leetcode437();
//        System.out.println(root.right.val);
        System.out.println(instance.pathSum(root,8));
    }
}
