package com.netease.spring.demo.algorithm.leetcode601_700;

import com.netease.spring.demo.algorithm.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fangsida
 * @date 2020/9/13
 */
public class Leetcode662 {
    int ans = 0;
    Map<Integer,Integer> leftMap = new HashMap<>();

    public int widthOfBinaryTree(TreeNode root) {

        dfs(root,0,0);
        return ans;
    }

    private void dfs(TreeNode root, int depth, int index) {
        if (null ==root){
            return;
        }

        leftMap.computeIfAbsent(depth,x->index);
        ans = Math.max(ans,index-leftMap.get(depth)+1);
        dfs(root.left,depth+1,index*2);
        dfs(root.right,depth+1,index*2+1);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(4);
        TreeNode right = new TreeNode(5);

        root.left = left;
        root.right = right;

        Leetcode662 instance = new Leetcode662();
        System.out.println(instance.widthOfBinaryTree(root));
    }
}
