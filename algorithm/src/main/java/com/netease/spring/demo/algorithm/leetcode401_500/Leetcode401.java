package com.netease.spring.demo.algorithm.leetcode401_500;

import java.util.LinkedList;
import java.util.List;

/**
 * 回溯法
 * https://leetcode-cn.com/problems/binary-watch/solution/di-gui-hui-su-suan-shi-bi-jiao-qing-xi-de-si-lu-ba/
 *
 * @author fangsida
 * @date 2020/5/6
 */
public class Leetcode401 {

    private List<String> res = new LinkedList<>();

    public List<String> readBinaryWatch(int num) {
        res.clear();
        dfs(num, 0, 0, 1, 1, new LinkedList<Integer>(), new LinkedList<Integer>());
        return res;
    }

    // h：小时数，m：分钟数
    // hstart、mstart：从hstart、mstart开始继续遍历小时和分钟
    // hours：选中的小时，minutes：选中的分钟
    private void dfs(int num, int h, int m, int hstart, int mstart, LinkedList<Integer> hours, LinkedList<Integer> minutes) {
        if (hours.size() + minutes.size() == num) {
            if (h < 12 && m < 60) {
                res.add(String.format("%d:%02d", h, m));
            }
            return;
        }
        for (int i = hstart; i <= 8; i <<= 1) {
            hours.addLast(i);
            dfs(num, h + i, m, i << 1, mstart, hours, minutes);
            hours.removeLast();
        }
        for (int i = mstart; i <= 32; i <<= 1) {
            minutes.addLast(i);
            dfs(num, h, m + i, 16, i << 1, hours, minutes); // hstart 直接设置为16（>=12)，避免重复计算
            minutes.removeLast();
        }
    }
}
