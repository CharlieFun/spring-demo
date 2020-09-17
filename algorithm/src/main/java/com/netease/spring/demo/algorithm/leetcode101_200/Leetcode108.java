package com.netease.spring.demo.algorithm.leetcode101_200;

import com.netease.spring.demo.algorithm.TreeNode;

/**
 * 本题简单，直接用leetcode题解
 * 作者：LeetCode-Solution
 * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/solution/jiang-you-xu-shu-zu-zhuan-huan-wei-er-cha-sou-s-33/
 * 来源：力扣（LeetCode）
 * @author fangsida
 * @date 2020/8/19
 */
public class Leetcode108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        // 总是选择中间位置左边的数字作为根节点
        int mid = (left + right) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }


}
