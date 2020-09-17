package com.netease.spring.demo.algorithm.leetcode301_400;

import java.util.LinkedList;

/**
 * @author fangsida
 * @date 2020/3/22
 */
public class Leetcode394 {

    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        Leetcode394 instance = new Leetcode394();
        System.out.println(instance.decodeString(s));
    }

    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        LinkedList<Integer> stack_multi = new LinkedList<>();
        LinkedList<String> stack_res = new LinkedList<>();

        for (char ch : s.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                multi = multi * 10 + Integer.parseInt(ch + "");
            } else if (ch == '[') {
                stack_multi.push(multi);
                stack_res.push(res.toString());
                multi = 0;
                res = new StringBuilder();
            } else if (ch == ']') {
                StringBuilder tmp = new StringBuilder();
                int num = stack_multi.pop();
                for (int i = 0; i < num; i++) {
                    tmp.append(res);
                }

                res = new StringBuilder(stack_res.poll() + tmp);
            } else {
                res.append(ch);
            }
        }

        return res.toString();
    }
}
