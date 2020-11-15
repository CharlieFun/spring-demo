package com.netease.spring.demo.algorithm.leetcode501_600;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fangsida
 * @date 2020/11/15
 */
public class Leetcode567 {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> needs = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c : s1.toCharArray()) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;

        int start = 0, len = Integer.MAX_VALUE;

        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;

            if (needs.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(needs.get(c))) {
                    valid++;
                }
            }

            while (right - left >= s1.length()) {
                if (valid == needs.size() && right-left == s1.length()) {
                    return true;
                }

                char d = s2.charAt(left);
                left++;

                if (needs.containsKey(d)) {
                    if (window.get(d).equals(needs.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);

                }
            }
        }

        return false;
    }
}
