package com.netease.spring.demo.algorithm.leetcode401_500;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fangsida
 * @date 2020/11/15
 */
public class Leetcode438 {

    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> needs = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            needs.put(p.charAt(i), needs.getOrDefault(p.charAt(i), 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;

        List<Integer> res = new ArrayList<>();

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            if (needs.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(needs.get(c))) {
                    valid++;
                }
            }

            while (right - left >= p.length()) {
                if (right - left == p.length() && valid == needs.size()) {
                    res.add(left);
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

        return res;
    }
}
