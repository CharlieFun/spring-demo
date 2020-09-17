package com.netease.spring.demo.algorithm.leetcode801_900;

import com.netease.spring.demo.algorithm.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fangsida
 * @date 2020/9/17
 */
public class Leetcode872 {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafList1 = new ArrayList<>();
        List<Integer> leafList2 = new ArrayList<>();
        dfs(root1, leafList1);
        dfs(root2, leafList2);
        return leafList1.equals(leafList2);
    }

    private void dfs(TreeNode root, List<Integer> leafList) {
        if (null != root) {
            if (null == root.left && null == root.right) {
                leafList.add(root.val);
            }
            dfs(root.left, leafList);
            dfs(root.right, leafList);
        }
    }
}
