package com.netease.spring.demo.algorithm.leetcode1_100;

import java.util.HashSet;
import java.util.Set;

/**
 * 无重复字符的最长子串
 * {@see https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/ }
 *
 * @author funstar
 * @date 2020/2/8
 */
public class Leetcode3 {

    /**
     * 双指针i，j，set记录已经保存的字符，如果s[j]不重复，s[j]加入set，j++，如果重复，s[i]从set移除，i++
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int res = 0,i = 0,j = 0;
        Set<Character> set = new HashSet<>();
        while (i<len && j<len){
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                res = Math.max(res,j-i+1);
                j++;
            }else{
                set.remove(s.charAt(i));
                i++;
            }

        }

        return res;

    }
}
