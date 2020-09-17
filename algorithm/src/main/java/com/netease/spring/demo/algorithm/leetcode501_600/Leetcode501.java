package com.netease.spring.demo.algorithm.leetcode501_600;

import com.netease.spring.demo.algorithm.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author fangsida
 * @date 2020/8/26
 */
public class Leetcode501 {

    List<Integer> list = new ArrayList<>();

    int maxCount = Integer.MIN_VALUE;

    int curNum = -1;

    int curCount = -1;

    public int[] findMode(TreeNode root) {
        inOrder(root);
        int[] res = new int[list.size()];
        for (int i=0;i<list.size();i++){
            res[i] = list.get(i);
        }
        return res;
    }

    private void inOrder(TreeNode root) {
        if (null == root){
            return;
        }
        inOrder(root.left);
        if (root.val == curNum){
            curCount++;
            if (curCount == maxCount){
                list.add(curNum);
            }else if (curCount > maxCount){
                list.clear();
                maxCount = curCount;
                list.add(curNum);
            }
        }else{
            curCount = 1;
            curNum = root.val;
            if (curCount == maxCount){
                list.add(curNum);
            }else if (curCount > maxCount){
                list.clear();
                maxCount = curCount;
                list.add(curNum);
            }
        }
        inOrder(root.right);
    }
}
