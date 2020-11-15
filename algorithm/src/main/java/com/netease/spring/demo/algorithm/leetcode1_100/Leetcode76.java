package com.netease.spring.demo.algorithm.leetcode1_100;

import java.util.HashMap;
import java.util.Map;

/**
 * 参考：labuladong公众号
 *
 * @author fangsida
 * @date 2020/11/15
 */
public class Leetcode76 {

    public static void main(String[] args) {
        Leetcode76 instance = new Leetcode76();
//        System.out.println(instance.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(Integer.MAX_VALUE);
    }

    public String minWindow(String s, String t) {
        Map<Character, Integer> needs = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c : t.toCharArray()) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;

        int start = 0, len = Integer.MAX_VALUE;

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            if (needs.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals( needs.get(c))) {
                    valid++;
                }
            }

            while (valid == needs.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }

                char d = s.charAt(left);
                left++;

                if (needs.containsKey(d)) {
                    if (window.get(d).equals(needs.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);

                }
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start+len);
    }
}
