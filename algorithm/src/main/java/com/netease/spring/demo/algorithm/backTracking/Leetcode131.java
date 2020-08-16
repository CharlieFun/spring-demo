package com.netease.spring.demo.algorithm.backTracking;

import java.util.LinkedList;
import java.util.List;

/**
 * 回溯法
 *
 * @author fangsida
 * @date 2020/5/6
 */
public class Leetcode131 {

    List<List<String>> res = new LinkedList<>();


    public List<List<String>> partition(String s) {
        LinkedList<String> track = new LinkedList<>();
        backTrack(s, track, 0);
        return res;
    }

    private void backTrack(String s, LinkedList<String> track, int start) {
        if (start == s.length()) {
            res.add(new LinkedList<>(track));
            return;
        }


        for (int end = start + 1; end <= s.length(); end++) {
            if (!isPalindrome(s.substring(start, end))) {
                continue;
            }

            track.add(s.substring(start, end));
            backTrack(s, track, end);
            track.removeLast();
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
        Leetcode131 instance = new Leetcode131();
        List<List<String>> res = instance.partition("aab");
        System.out.println(res);
    }
}
