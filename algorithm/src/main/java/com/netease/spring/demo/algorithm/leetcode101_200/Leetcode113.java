package com.netease.spring.demo.algorithm.leetcode101_200;

import com.netease.spring.demo.algorithm.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author fangsida
 * @date 2020/8/20
 */
public class Leetcode113 {

    List<List<Integer>> res = new LinkedList<>();

    /* 主函数，输入一组不重复的数字，返回它们的全排列 */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        // 记录「路径」
        // 这里的 选择列表 即包含在nums中
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(root, sum, track);
        return res;
    }

    // 路径：记录在 track 中
// 选择列表：nums 中的元素
// 结束条件：nums 中的元素全都在 track 中出现
    void backtrack(TreeNode root, int sum, LinkedList<Integer> track) {
        if (null == root) {
            return;
        }

        track.add(root.val);
        // 触发结束条件
        if (root.left == null && root.right == null && root.val == sum) {
            res.add(new LinkedList(track));
            return;
        }

        backtrack(root.left, sum - root.val, track);
        backtrack(root.right, sum - root.val, track);

        // 取消选择，返回上一层决策树
        track.removeLast();

    }
}
