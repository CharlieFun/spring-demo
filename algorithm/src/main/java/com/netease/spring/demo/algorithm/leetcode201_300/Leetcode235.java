package com.netease.spring.demo.algorithm.leetcode201_300;

import com.netease.spring.demo.algorithm.TreeNode;

/**
 * @author fangsida
 * @date 2020/8/23
 */
public class Leetcode235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root.val>p.val && root.val>q.val){
            return lowestCommonAncestor(root.left,p,q);
        }

        if (root.val<p.val && root.val<q.val){
            return lowestCommonAncestor(root.right,p,q);
        }

        return root;
    }
}
