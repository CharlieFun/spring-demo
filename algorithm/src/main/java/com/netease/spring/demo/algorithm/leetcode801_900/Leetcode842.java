package com.netease.spring.demo.algorithm.leetcode801_900;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 参考：https://leetcode-cn.com/problems/split-array-into-fibonacci-sequence/solution/java-dfs-jia-jian-zhi-ji-bai-liao-9306-by-capta1n/
 *
 * @author fangsida
 * @date 2020/11/21
 */
public class Leetcode842 {
    LinkedList<Integer> track = new LinkedList<>();


    public List<Integer> splitIntoFibonacci(String S) {
        return backTrack(S, 0, 0, 0, 0) ? track : new ArrayList<>();
    }

    private boolean backTrack(String s, int pre1, int pre2, int deep, int start) {
        if (start == s.length()) {
            return deep >= 3;
        }

        for (int i = 1; i < 11; i++) {
            //超出长度或者以0开头直接break;
            if (start + i > s.length() || (s.charAt(start) == '0' && i > 1)) {
                break;
            }

            //截取字符串
            String sub = s.substring(start, start + i);

            long numL = Long.parseLong(sub);
            //判断是否超出范围,或者deep不是0,1却大于他的前两个数之和
            if (numL > Integer.MAX_VALUE ||
                    (deep != 0 && deep != 1 && numL > (pre1 + pre2))) {
                break;
            }
            //转成int
            Integer num = (int) numL;
            //满足条件的数,递归加回溯
            if (deep == 0 || deep == 1 || num.equals(pre1 + pre2)) {
                track.add(num);
                if (backTrack(s, pre2, num, deep + 1, start + i)) {
                    return true;
                }
                track.removeLast();
            }

        }
        return false;
    }
}
