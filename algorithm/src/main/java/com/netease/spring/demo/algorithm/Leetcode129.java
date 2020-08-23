package com.netease.spring.demo.algorithm;

/**
 * @author fangsida
 * @date 2020/8/23
 */
public class Leetcode129 {

    int res = 0;


    public int sumNumbers(TreeNode root) {
        help(root, 0);
        return res;
    }

    private void help(TreeNode root, int sum) {
        if (null == root) {
            return;
        }

        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            res += sum;
        }
        help(root.left, sum);
        help(root.right, sum);
        sum = (sum - root.val) / 10;
    }
}
