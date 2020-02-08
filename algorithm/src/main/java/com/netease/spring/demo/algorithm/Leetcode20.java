package com.netease.spring.demo.algorithm;

import java.util.ArrayDeque;

/**
 * 有效的括号
 * https://leetcode-cn.com/problems/valid-parentheses/
 *
 * @author funstar
 * @date 2020/2/8
 */
public class Leetcode20 {

    public boolean isValid(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (Character ch : s.toCharArray()) {
            if ('(' == ch || '[' == ch || '{' == ch) {
                stack.push(ch);
            } else {
                Character top = stack.peek();
                if (null == top) {
                    return false;
                } else if ('(' == top && ')' == ch) {
                    stack.pop();
                } else if ('[' == top && ']' == ch) {
                    stack.pop();
                } else if ('{' == top && '}' == ch) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        if (stack.size() == 0) {
            return true;
        }
        return false;
    }
}
