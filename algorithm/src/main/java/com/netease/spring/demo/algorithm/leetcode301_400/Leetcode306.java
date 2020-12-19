package com.netease.spring.demo.algorithm.leetcode301_400;

import com.netease.spring.demo.algorithm.leetcode1_100.Leetcode78;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author fangsida
 * @date 2020/11/21
 */
public class Leetcode306 {

//    LinkedList<Integer> track = new LinkedList<>();

    /**
     * 获取 l ~ r 组成的有效数字
     * 如果超出了范围则小于0
     */
    private static long fetchCurValue(String num, int l, int r) {
        if (l + 1 < r && num.charAt(l) == '0') {
            return -1;
        }
        long res = 0;
        while (l < r) {
            res = res * 10 + num.charAt(l++) - '0';
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode306 ins = new Leetcode306();
//        System.out.println(ins.isAdditiveNumber("11235813213455890144"));
        System.out.println(fetchCurValue("11235813213455890144", 0, "11235813213455890144".length()));
    }

    public boolean isAdditiveNumber(String num) {
        return backTrack(num, 0, 0, 0, 0);
    }

    private boolean backTrack(String s, long pre1, long pre2, int deep, int start) {
        if (start == s.length()) {
            return deep >= 3;
        }

        for (int i = 1; i < s.length() - start + 1; i++) {
            //超出长度或者以0开头直接break;
            if (s.charAt(start) == '0' && i > 1) {
                break;
            }

            //截取字符串
//            String sub = s.substring(start, start + i);

//            System.out.println(sub);
            Long num = fetchCurValue(s, start, start + i);
            if (num < 0) {
                continue;
            }
            //判断是否超出范围,或者deep不是0,1却大于他的前两个数之和
            if (
                    deep != 0 && deep != 1 && num > (pre1 + pre2)) {
                break;
            }
            //满足条件的数,递归加回溯
            if (deep == 0 || deep == 1 || num.equals(pre1 + pre2)) {
                if (backTrack(s, pre2, num, deep + 1, start + i)) {
                    return true;
                }
            }

        }
        return false;
    }
}
