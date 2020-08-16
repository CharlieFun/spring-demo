package com.netease.spring.demo.study.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 基于LinkedHashMap实现LRU
 * @author fangsida
 * @date 2020/5/2
 */
public class LruLinkedHashMap<K, V> {

    private int size;

    private float factor;

    private LinkedHashMap<K, V> linkedHashMap;

    public LruLinkedHashMap(int size, float factor) {
        this.linkedHashMap = new LinkedHashMap<K, V>(size, factor, true) {

            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                boolean tooBig = size() > size;

                if (tooBig) {
                    System.out.println("最近最少使用的key=" + eldest.getKey());
                }
                return tooBig;

            }
        };
    }

    public V put(K k, V v) {
        return linkedHashMap.put(k, v);
    }

    public V get(K k) {
        return linkedHashMap.get(k);
    }

    public String toString(){
        return linkedHashMap.toString();
    }


    public static void main(String[] args) {
        LruLinkedHashMap<String,String> map = new LruLinkedHashMap(5, 0.75f);
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        map.put("4", "4");
        map.put("5", "5");
        System.out.println(map.toString());

        map.put("6", "6");
        map.get("2");
        map.put("7", "7");
        map.get("4");
        System.out.println(map.toString());

    }
}
