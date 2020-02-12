package com.netease.spring.demo.algorithm;

import java.util.LinkedList;
import java.util.List;

/**
 * 全排列回溯法模板
 * 思路
 * 直接上回溯算法框架。解决一个回溯问题，实际上就是一个决策树的遍历过程。你只需要思考 3 个问题：
 *
 * 1、路径：也就是已经做出的选择。
 *
 * 2、选择列表：也就是你当前可以做的选择。
 *
 * 3、结束条件：也就是到达决策树底层，无法再做选择的条件。
 *  result = []
 * def backtrack(路径, 选择列表):
 *     if 满足结束条件:
 *         result.add(路径)
 *         return
 *
 * for 选择 in 选择列表:
 *     做选择
 *     backtrack(路径, 选择列表)
 *     撤销选择
 *
 * 作者：jeromememory
 * 链接：https://leetcode-cn.com/problems/combination-sum/solution/hui-su-suan-fa-tao-mo-ban-ji-ke-by-jeromememory/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author funstar
 * @date 2020/2/11
 */
public class BackTrackDemo {
    List<List<Integer>> res = new LinkedList<>();

    /* 主函数，输入一组不重复的数字，返回它们的全排列 */
    List<List<Integer>> permute(int[] nums) {
        // 记录「路径」
        // 这里的 选择列表 即包含在nums中
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    // 路径：记录在 track 中
// 选择列表：nums 中的元素
// 结束条件：nums 中的元素全都在 track 中出现
    void backtrack(int[] nums, LinkedList<Integer> track) {
        // 触发结束条件
        if (track.size() == nums.length) {
            res.add(new LinkedList(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择
            if (track.contains(nums[i]))
                continue;
            // 做选择
            track.add(nums[i]);
            // 进入下一层决策树
            backtrack(nums, track);
            // 取消选择，返回上一层决策树
            track.removeLast();
        }
    }
}
