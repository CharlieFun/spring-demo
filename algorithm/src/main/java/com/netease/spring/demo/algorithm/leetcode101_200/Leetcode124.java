package com.netease.spring.demo.algorithm.leetcode101_200;

import com.netease.spring.demo.algorithm.TreeNode;

/**
 * @author fangsida
 * @date 2020/12/21
 */
public class Leetcode124 {

    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMax = Math.max(0, dfs(root.left));
        int rightMax = Math.max(0, dfs(root.right));

        res = Math.max(res, root.val + leftMax + rightMax);

        return root.val + Math.max(leftMax, rightMax);
    }

}
