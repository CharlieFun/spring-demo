package com.netease.spring.demo.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fangsida
 * @date 2020/8/18
 */
public class Leetcode95 {

    public List<TreeNode> generateTrees(int n) {
        if (n==0){
            return new ArrayList<>();
        }
        return generateTrees(1,n);
    }

    public List<TreeNode> generateTrees(int low, int high) {
        List<TreeNode> list = new ArrayList<>();

        if (low > high) {
            list.add(null);
            return list;
        }

        for (int i=low;i<=high;i++){
            List<TreeNode> leftList = generateTrees(low,i-1);
            List<TreeNode> rightList = generateTrees(i+1,high);
            for (TreeNode left:leftList){
                for (TreeNode right:rightList){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    list.add(root);
                }
            }

        }
        return list;
    }
}
