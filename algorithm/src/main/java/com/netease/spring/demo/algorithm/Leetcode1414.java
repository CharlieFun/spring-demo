package com.netease.spring.demo.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fangsida
 * @date 2020/7/15
 */
public class Leetcode1414 {

    public int findMinFibonacciNumbers(int k) {
        List<Integer> list = new ArrayList<>();
        int a = 1;
        int b = 1;
        int c = a + b;
        list.add(a);
        list.add(b);
        while (c <= k) {
            list.add(c);
            a = b;
            b = c;
            c = a + b;
        }

        int count = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            int num = list.get(i);
            if (k > num) {
                count++;
                k -= list.get(i);
            }else if (k== num){
                count++;
                break;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Leetcode1414 ins = new Leetcode1414();
        System.out.println(ins.findMinFibonacciNumbers(19));
    }
}
