package com.netease.spring.demo.algorithm;

import java.util.ArrayDeque;

/**
 * https://leetcode-cn.com/problems/min-stack/
 * 最小栈
 *
 * @author fangsida
 * @date 2020/2/16
 */
public class Leetcode155 {


    public static void main(String[] args) {
        Leetcode155 ins = new Leetcode155();
        MinStack minStack = ins.new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());

        System.out.println(minStack.getMin());

    }

    class MinStack {
        ArrayDeque<Integer> data;

        ArrayDeque<Integer> helper;


        /**
         * initialize your data structure here.
         */
        public MinStack() {
            data = new ArrayDeque<>();
            helper = new ArrayDeque<>();
        }

        public void push(int x) {
            data.push(x);
            if (!helper.isEmpty() && helper.peek() < x) {
                helper.push(helper.peek());
            } else {

                helper.push(x);
            }

        }

        public void pop() {
            if (!data.isEmpty()) {
                data.pop();
                helper.pop();
            }

        }

        public int top() {
            if (!data.isEmpty()) {
                return data.peek();
            }

            return -1;
        }

        public int getMin() {
            if (!data.isEmpty()) {
                return helper.peek();
            }

            return -1;

        }


    }
}
