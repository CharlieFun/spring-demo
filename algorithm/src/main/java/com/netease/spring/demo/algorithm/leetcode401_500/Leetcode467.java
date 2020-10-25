package com.netease.spring.demo.algorithm.leetcode401_500;

/**
 * @author fangsida
 * @date 2020/10/25
 */
public class Leetcode467 {

    public int findSubstringInWraproundString(String p) {
        int[] dp = new int[26];
        int count = 1;
        char[] chars = (" " + p).toCharArray();
        for (int i = 1; i < chars.length; i++) {
            int index = chars[i] - 'a';
            if (continuous(chars[i], chars[i - 1])) {
                count++;
            } else {
                count = 1;
            }

            dp[index] = Math.max(dp[index], count);
        }

        int ans = 0;

        for (int i = 0; i < dp.length; i++) {
            ans += dp[i];
        }

        return ans;
    }

    private boolean continuous(char a, char b) {
        if (a == 'a' && b == 'z') {
            return true;
        }

        return a - b == 1;
    }

}
