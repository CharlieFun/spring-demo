package com.netease.spring.demo.algorithm;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * 从前序与中序遍历序列构造二叉树
 *
 * @author funstar
 * @date 2020/2/9
 */
public class Leetcode105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, inorder, 0, preorder.length, 0, inorder.length);
    }

    public TreeNode buildTreeHelper(int[] preOrder, int[] inOrder, int pStart, int pEnd, int iStart, int iEnd) {
        if (pStart == pEnd) {
            return null;
        }

        int rootVal = preOrder[pStart];
        TreeNode root = new TreeNode(rootVal);

        //中序遍历中根节点索引
        int inRootIndex = 0;

        //从中序遍历找到根节点，确定左子树长度
        for (int i = iStart; i < iEnd; i++) {
            if (inOrder[i] == rootVal) {
                inRootIndex = i;
                break;
            }
        }

        int leftLen = inRootIndex - iStart;

        root.left = buildTreeHelper(preOrder, inOrder, pStart + 1, pStart + 1 + leftLen, iStart, inRootIndex);
        root.right = buildTreeHelper(preOrder, inOrder, pStart + 1 + leftLen, pEnd, inRootIndex + 1, iEnd);

        return root;
    }
}
