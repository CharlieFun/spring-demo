package com.netease.spring.demo.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * @author fangsida
 * @date 2020/8/29
 */
public class Leetcode653 {

    private Set<Integer> set = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        if(root == null)
            return false;
        if(set.contains(k - root.val))
            return true;
        set.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }

}
