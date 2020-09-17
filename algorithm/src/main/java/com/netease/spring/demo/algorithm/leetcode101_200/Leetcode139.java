package com.netease.spring.demo.algorithm.leetcode101_200;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/word-break/
 * 单词拆分
 *
 * @author fangsida
 * @date 2020/2/15
 */
public class Leetcode139 {

    Map<String, Boolean> memory = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<Character> dictSet = new HashSet<>();
        for (int i = 0; i < wordDict.size(); i++) {
            String t = wordDict.get(i);
            for (int j = 0; j < t.length(); j++) {
                dictSet.add(t.charAt(j));
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (!dictSet.contains(s.charAt(i))) {
                return false;
            }
        }

        return backTrack(s, wordDict, "");

    }

    private boolean backTrack(String target, List<String> wordDict, String temp) {
        if (temp.length() > target.length()) {
            return false;
        }

        //发现之前已经尝试过以temp开头的字符串，直接返回之前尝试的结果
        if (memory.containsKey(temp)) {
            return memory.get(temp);
        }

        for (int i = 0; i < temp.length(); i++) {
            if (target.charAt(i) != temp.charAt(i)) {
                return false;
            }
        }
        if (target.length() == temp.length()) {
            return true;
        }

        for (int i = 0; i < wordDict.size(); i++) {
            if (backTrack(target, wordDict, temp + wordDict.get(i))) {
                return true;
            } else {
                memory.put(temp + wordDict.get(i), false);
            }
        }

        memory.put(temp, false);
        return false;
    }
}
