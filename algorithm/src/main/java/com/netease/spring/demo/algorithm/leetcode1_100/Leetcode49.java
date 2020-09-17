package com.netease.spring.demo.algorithm.leetcode1_100;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/group-anagrams/
 * 字母异位词分组
 *
 * @author funstar
 * @date 2020/2/11
 */
public class Leetcode49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (null == strs || strs.length == 0){
            return new ArrayList<>();
        }

        Map<String,List<String>> ans = new HashMap<>();
        for (String str: strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortStr = String.valueOf(chars);
            if (ans.containsKey(sortStr)){
                ans.get(sortStr).add(str);
            }else{
                List<String> list = new ArrayList<>();
                list.add(str);
                ans.put(sortStr,list);
            }
        }

        return new ArrayList<>(ans.values());
    }
}
