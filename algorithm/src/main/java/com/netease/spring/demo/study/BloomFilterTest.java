package com.netease.spring.demo.study;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fangsida
 * @date 2020/12/6
 */
public class BloomFilterTest {

    public static void main(String[] args) {
//        BloomFilter<Integer> bf = BloomFilter.create(Funnels.integerFunnel(), total);
        List<String> list = new ArrayList<>();
        String s = new String("abc");
        list.add(s);
        s = null;
        System.out.println(list);
    }
}
