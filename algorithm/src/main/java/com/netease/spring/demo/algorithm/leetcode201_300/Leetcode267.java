package com.netease.spring.demo.algorithm.leetcode201_300;

import java.util.*;

/**
 * 该解法超时了，新思路：
 * 先判断是否能构成回文，判断方法：对字符串进行统计，如果每个字符个数都是偶数，或者只有一个字符是奇数，其他都是偶数，则可以构成
 * 然后生成一个每个字符一半的list，进行回溯全排列，即生成回文的前半部分，然后补足后半部分加入res数组中
 * @author fangsida
 * @date 2020/5/7
 */
public class Leetcode267 {

    Set<String> res = new HashSet<>();

    public List<String> generatePalindromes(String s) {

        StringBuilder builder = new StringBuilder();
        boolean[] used = new boolean[s.length()];
        boolean isEven = s.length() % 2 == 0;
        backTrack(s, builder, used);
        return new ArrayList<>(res);
    }

    private void backTrack(String s, StringBuilder builder, boolean[] used) {
        String str = builder.toString();
        int len = s.length();
        if (str.length() == len) {
            res.add(str);
            return;
        }

        int blen = builder.length();
        for (int i = 0; i < len; i++) {
            if (!used[i] && (blen <= (len - 1) / 2 || builder.charAt(len - blen- 1) == s.charAt(i))) {
                used[i] = true;
                builder.append(s.charAt(i));
                backTrack(s, builder, used);
                used[i] = false;
                builder.deleteCharAt(builder.length()-1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        if (s.length() <= 1) {
            return true;
        }

        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Leetcode267 instance = new Leetcode267();
        System.out.println(instance.generatePalindromes("aabb"));
    }
}
