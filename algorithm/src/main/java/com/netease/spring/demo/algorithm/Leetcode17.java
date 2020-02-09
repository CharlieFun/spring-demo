package com.netease.spring.demo.algorithm;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/solution/dian-hua-hao-ma-de-zi-mu-zu-he-by-leetcode/
 * 电话号码的字母组合
 *
 * @author funstar
 * @date 2020/2/9
 */
public class Leetcode17 {

    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};


    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (null == digits || digits.length() == 0) {
            return res;
        }

        if (digits.length() == 1) {
            char[] chars = (phone.get(digits).toCharArray());
            for (char ch : chars) {
                res.add(String.valueOf(ch));
            }
            return res;
        }

        List<String> preList = letterCombinations(digits.substring(0, digits.length() - 1));
        List<String> lastList = letterCombinations(digits.substring(digits.length() - 1));
        for (String pre : preList) {
            for (String last : lastList) {
                String s = pre + last;
                res.add(s);
            }
        }

        return res;
    }
}
