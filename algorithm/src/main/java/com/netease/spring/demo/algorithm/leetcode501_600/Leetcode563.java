package com.netease.spring.demo.algorithm.leetcode501_600;

import com.netease.spring.demo.algorithm.TreeNode;

/**
 * @author fangsida
 * @date 2020/8/28
 */
public class Leetcode563 {
    int ans = 0;
    public int findTilt(TreeNode root) {
        sum(root);
        return ans;
    }

    public int sum(TreeNode root){
        if (root == null){
            return 0;
        }

        int left = sum(root.left);
        int right = sum(root.right);
        ans += Math.abs(left-right);
        return left+right+root.val;
    }
}
