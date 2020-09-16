package com.netease.spring.demo.algorithm;

/**
 * @author fangsida
 * @date 2020/9/15
 */
public class Leetcode687 {
    int ans = 0;

    public int longestUnivaluePath(TreeNode root) {
        helper(root);
        return ans;
    }

    // 搜索以root为起点的最长同值路径
    // 要么经过左子树，要么经过右子树
    private int helper(TreeNode root) {
       if (null == root){
           return 0;
       }

       int maxLen = 0;
       int leftLen = helper(root.left);
       int rightLen = helper(root.right);
        if (root.left != null && root.right != null &&
                root.val == root.left.val && root.val == root.right.val) {
            ans = Math.max(ans, leftLen + rightLen + 2);
        }
        // 从左右子树中选取最长同值路径
        if (root.left != null && root.val == root.left.val) {
            maxLen = leftLen + 1;
        }
        if (root.right != null && root.val == root.right.val) {
            maxLen = Math.max(maxLen, rightLen + 1);
        }
        // 更新结果
        ans = Math.max(ans, maxLen);
        return maxLen;

    }
}
