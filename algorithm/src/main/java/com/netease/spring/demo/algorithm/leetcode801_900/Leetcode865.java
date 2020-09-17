package com.netease.spring.demo.algorithm.leetcode801_900;

import com.netease.spring.demo.algorithm.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fangsida
 * @date 2020/9/17
 */
public class Leetcode865 {

    Map<TreeNode, Integer> depth = new HashMap();

    int max_depth = -1;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {

        dfs(root, 0);

        return helper(root);
    }

    public void dfs(TreeNode node, Integer dep) {
        if (node != null) {
            depth.put(node, dep);
            dfs(node.left, dep + 1);
            dfs(node.right, dep + 1);
            max_depth = Math.max(max_depth, dep);
        }
    }

    public TreeNode helper(TreeNode node) {
        if (node == null || depth.get(node) == max_depth) {
            return node;
        }
        TreeNode L = helper(node.left),
                R = helper(node.right);
        if (L != null && R != null) {
            return node;
        }
        if (L != null) {
            return L;
        }
        if (R != null) {
            return R;
        }
        return null;
    }

}
