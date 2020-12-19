package com.netease.spring.demo.algorithm;


/**
 * @author fangsida
 * @date 2020/11/23
 */
public class Leetcode1415 {

    char[] chars = {'a', 'b', 'c'};

    String res = "";

    int count = 0;

    public String getHappyString(int n, int k) {
        StringBuilder builder = new StringBuilder();

        dfs(n, k, builder, 'd');
        return res;
    }

    private void dfs(int n, int k, StringBuilder builder, char pre) {
        if (builder.length() == n) {
            count++;
            if (count == k) {
                res = builder.toString();
            }
            return;
        }

        for (char ch : chars) {
            if (ch == pre) {
                continue;
            }

            builder.append(ch);
            dfs(n, k, builder, ch);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    public static void main(String[] args) {
        Leetcode1415 ins = new Leetcode1415();
        System.out.println(ins.getHappyString(1,3));
    }
}
