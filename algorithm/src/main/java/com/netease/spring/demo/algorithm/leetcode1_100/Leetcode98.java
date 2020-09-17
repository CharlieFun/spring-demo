package com.netease.spring.demo.algorithm.leetcode1_100;

import com.netease.spring.demo.algorithm.TreeNode;

/**
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 * 验证二叉搜索树
 *
 * @author funstar
 * @date 2020/2/9
 */
public class Leetcode98 {

    public boolean isValidBST(TreeNode root) {
        if (null == root){
            return true;
        }

        boolean isLeftValidBST = false;
        boolean isRightValidBST = false;

        if (null == root.left){
            isLeftValidBST = true;
        }else{
            isLeftValidBST = findRightest(root.left).val<root.val && isValidBST(root.left);
        }

        if (null == root.right){
            isRightValidBST = true;
        }else{
            isRightValidBST = findLeftest(root.right).val>root.val && isValidBST(root.right);
        }

        return  isLeftValidBST && isRightValidBST;


    }

    private TreeNode findLeftest(TreeNode node) {
        while (node != null && node.left != null){
            node = node.left;
        }

        return node;
    }

    private TreeNode findRightest(TreeNode node) {
        while (node != null && node.right != null){
            node = node.right;
        }

        return node;
    }
}
