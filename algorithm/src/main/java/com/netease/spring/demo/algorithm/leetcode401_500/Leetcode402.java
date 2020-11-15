package com.netease.spring.demo.algorithm.leetcode401_500;

import com.netease.spring.demo.algorithm.leetcode1_100.Leetcode78;

import java.util.LinkedList;

/**
 * @author fangsida
 * @date 2020/11/15
 */
public class Leetcode402 {

    public String removeKdigits(String num, int k) {
        if (k >= num.length()) {
            return "0";
        }

        LinkedList<Integer> queue = new LinkedList<>();

        int i = 0;
        int del = 0;
        while (i < num.length()) {
            Integer cur = num.charAt(i) -'0';
            while (!queue.isEmpty() && del < k && queue.getLast() > cur) {
                queue.removeLast();
                del++;
            }

            queue.offer(cur);
            i++;
        }

        while (del < k) {
            queue.removeLast();
            del++;
        }

        boolean isZero;

        StringBuilder builder = new StringBuilder();
        while (!queue.isEmpty()) {
            isZero = queue.peek() == 0;
            if (!isZero) {
                break;
            }

            queue.removeFirst();
        }

        while (!queue.isEmpty()) {
            builder.append(queue.removeFirst());
        }

        if (builder.length() == 0){
            return "0";
        }else{
            return builder.toString();
        }


    }

    public static void main(String[] args) {
        Leetcode402 instance = new Leetcode402();
        System.out.println(instance.removeKdigits("1234567890",9));
    }
}
