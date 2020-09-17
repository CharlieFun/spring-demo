package com.netease.spring.demo.algorithm.leetcode1_100;

/**
 * 最长回文子串
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 *
 * @author funstar
 * @date 2020/2/8
 */
public class Leetcode5 {

    //题解 https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zhong-xin-kuo-san-dong-tai-gui-hua-by-liweiwei1419/

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len <= 1) {
            return s;
        }

        int max = 1;
        String res = s.substring(0, 1);

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (j - i + 1 > max && valid(s, i, j)) {
                    max = j - i + 1;
                    res = s.substring(i, j + 1);
                }
            }
        }

        return res;
    }

    private boolean valid(String s, int i, int j) {
        while (i < j){
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}
