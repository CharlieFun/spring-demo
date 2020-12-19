package com.netease.spring.demo.algorithm.leetcode1_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 本题与子集 总的组合 II 全排列 II 类似， 关键点在于如何在回溯中进行剪枝
 * 这种需要去除解集中重复的子集的题目通常都需要先对输入的元素进行排序， 让相同的元素聚在一起， 这样就可以据此进行剪枝。
 *
 * 剪枝思路：
 * 以 [1, 2, 2']（2' 的 " ' " 是为了理解方便加的） 为例
 * 如果按照子集 的剪枝方案将会得到的非空子集为： [[1],[1,2],[1,2,2'],[1,2'],[2],[2,2'],[2']]
 *
 * 出现重复解的为 [2] [2'] 和 [1, 2] [1, 2']
 * 观察选取到重复的解的特点， 重复的解是因为有 2 个或以上个相同的元素（如 2， 2'）在同一层回溯过程中被分别选择， 作为最终解的一部分了.
 * 所以处理这种问题， 就是要在回溯过程中区分出来这种数值相同的情况（就是要区分出来 2 == 2'）
 * 因为输入数据已经经过排序， 所以一种显而易见的做法就是在回溯时， 检查当前元素是否和上一个元素相同，即 nums[i - 1] == nums[i] 如果发现和上一个相同了就饿可以直接跳过（如 nums = [1, 2, 2'] nums[1] == nums[2], nums[2] 就直接跳过了）
 * 需要注意的是 nums[i - 1] == nums[i] 的作用是在递归树的同一层上的， 也就是防止 nums = [1, 2, 2'] 出现 [1, 2]， [1, 2'] 两个重复的解 （即： 通过 nums[1] == nums[2]: continue 进行的剪枝）
 * 而解 [1, 2, 2'] 实际中的 2, 2' 是位于递归树的不同层级的， 也就是剪枝要从每一层的第二个元素开始， 所以还要增加一个 i > start 或者 i != start
 * 最终相对于子集 的思路就是要增加一个 i > start && nums[i - 1] == nums[i] 或 i != start && nums[i - 1] == nums[i] 的剪枝
 *
 * 作者：mrsate
 * 链接：https://leetcode-cn.com/problems/subsets-ii/solution/jian-zhi-qu-zhong-de-si-lu-by-mrsate/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author fangsida
 * @date 2020/11/20
 */
public class Leetcode90 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();

        Arrays.sort(nums);

        backTack(nums, track, 0);
        return res;
    }

    private void backTack(int[] nums, LinkedList<Integer> track, int start) {
        res.add(new ArrayList<>(track));

        if (start == nums.length) {
            return;
        }

        for (int i = start; i < nums.length; i++) {

            //start表示决策树的深度，同一层树，不能重复选相同元素，但start不同时，
            //即不同层的时候，元素可以重复
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            track.add(nums[i]);
            backTack(nums, track, i+1);
            track.removeLast();

        }
    }

    public static void main(String[] args) {
        Leetcode90 ins = new Leetcode90();
        int[] arr = {1,2,2,2};
        System.out.println(ins.subsetsWithDup(arr));
    }
}
