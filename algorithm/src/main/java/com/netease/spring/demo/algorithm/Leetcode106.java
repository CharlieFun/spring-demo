package com.netease.spring.demo.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fangsida
 * @date 2020/8/19
 */
public class Leetcode106 {

    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return this.helper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode helper(int[] inorder, int[] postorder, int inL, int inR, int postL, int postR) {
        if (inL > inR) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postR]);
        int inRootIndex = map.get(postorder[postR]);
        int len = inRootIndex - inL;
        root.left = helper(inorder, postorder, inL, inRootIndex - 1, postL, postL + len - 1);
        root.right = helper(inorder, postorder, inRootIndex + 1, inR, postL + len, postR - 1);

        return root;
    }
}
