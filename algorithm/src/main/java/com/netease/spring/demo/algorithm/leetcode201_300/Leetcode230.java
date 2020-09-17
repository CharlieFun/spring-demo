package com.netease.spring.demo.algorithm.leetcode201_300;

import com.netease.spring.demo.algorithm.TreeNode;

import java.util.LinkedList;

/**
 * @author fangsida
 * @date 2020/8/23
 */
public class Leetcode230 {

    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();

        TreeNode cur = root;

        while (cur!= null || !stack.isEmpty()){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            k--;
            if (k==0){
                return cur.val;
            }

            cur=cur.right;
        }

        return -1;

    }


}
