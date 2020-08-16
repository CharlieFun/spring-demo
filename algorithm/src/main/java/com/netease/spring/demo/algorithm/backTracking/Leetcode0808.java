package com.netease.spring.demo.algorithm.backTracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutation-ii-lcci/
 * 题目描述：有重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合
 * 示例：
 * 输入：S = "qqe"
 * 输出：["eqq","qeq","qqe"]
 *
 * @author fangsida
 * @date 2020/5/6
 */
public class Leetcode0808 {

    List<String> res = new LinkedList<>();

    public String[] permutation(String S) {
        StringBuilder track = new StringBuilder();
        char[] charArray = S.toCharArray();
        //进行排序
        Arrays.sort(charArray);

        boolean[] used = new boolean[S.length()];
        backTrack(charArray, track, used);
        return res.toArray(new String[0]);
    }

    private void backTrack(char[] sChar, StringBuilder track, boolean[] used) {
        //触发结束条件
        if (track.length() == sChar.length) {
            res.add(track.toString());
            return;
        }

        for (int i = 0; i < sChar.length; i++) {
            if (!used[i]) {
                //剪枝，sChar排序后，如果sChar[i]=sChar[i-1],则要保持顺序使用
                if (i > 0 && sChar[i] == sChar[i - 1] && !used[i - 1]) {
                    continue;
                }

                //做选择
                track.append(sChar[i]);
                used[i] = true;
                //进入下一层决策树
                backTrack(sChar, track, used);
                //取消选择，返回上一层决策树
                track.deleteCharAt(track.length() - 1);
                used[i] = false;
            }
        }
    }
}
