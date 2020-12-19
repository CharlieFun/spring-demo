package com.netease.spring.demo.algorithm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author fangsida
 * @date 2020/11/22
 */
public class Leetcode1286 {

    static class CombinationIterator {

        List<String> res;

        Iterator<String> iter;

        public CombinationIterator(String characters, int combinationLength) {
            res = new ArrayList<>();
            StringBuilder builder = new StringBuilder();
            backTrack(characters, combinationLength, 0, builder);
            iter = res.iterator();
        }

        private void backTrack(String characters, int combinationLength, int start, StringBuilder builder) {
            if (builder.length() == combinationLength) {
                res.add(builder.toString());
                return;
            }

            for (int i = start; i < characters.length(); i++) {
                builder.append(characters.charAt(i));
                backTrack(characters, combinationLength, i + 1, builder);
                builder.deleteCharAt(builder.length() - 1);
            }
        }

        public String next() {
            return iter.next();
        }

        public boolean hasNext() {
            return iter.hasNext();
        }
    }

    public static void main(String[] args) {
        CombinationIterator iterator = new CombinationIterator("abc", 2); // 创建迭代器 iterator

        System.out.println(iterator.next()); // 返回 "ab"
        System.out.println(iterator.hasNext()); // 返回 true
        System.out.println(iterator.next()); // 返回 "ac"
        System.out.println(iterator.hasNext()); // 返回 true
        System.out.println(iterator.next()); // 返回 "bc"
        System.out.println(iterator.hasNext()); // 返回 false

    }
}
