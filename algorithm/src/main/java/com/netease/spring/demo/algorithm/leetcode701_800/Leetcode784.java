package com.netease.spring.demo.algorithm.leetcode701_800;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯法
 * 转载：https://leetcode-cn.com/problems/letter-case-permutation/solution/jian-dan-de-dfsjian-dan-bu-jian-dan-ni-shuo-liao-s/
 * @author fangsida
 * @date 2020/5/6
 */
public class Leetcode784 {

    public static void main(String[] args) {
        Leetcode784 instance = new Leetcode784();
        System.out.println(instance.letterCasePermutation("a1b2"));
    }

    public static void dfs(StringBuilder s, int index, List<String> res) {
        if(index >= s.length()) {
            res.add(s.toString());
            return;
        }
        char ch = s.charAt(index);
        if(Character.isLetter(ch)) {
            dfs(s, index+1, res);					// 搜索原字母的组合
            s.setCharAt(index, (char)(ch ^ 32));
            dfs(s, index+1, res);					// 搜索转换字母大小写后的组合
        } else dfs(s, index+1, res);				// 该位为数字，直接往后搜
    }

    public static List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<String>();
        dfs(new StringBuilder(S), 0, res);
        return res;
    }
}
