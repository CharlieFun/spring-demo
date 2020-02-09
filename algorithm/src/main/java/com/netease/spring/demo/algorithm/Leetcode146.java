package com.netease.spring.demo.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/lru-cache/
 * LRU缓存机制
 * 实现方法有两种：
 * 1.链表+HashMap
 * 2.LinkedHashMap
 *
 * @author funstar
 * @date 2020/2/9
 */
public class Leetcode146 {

    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */

    class LRUCache {

        int capacity;
        Node head = null;
        Node end = null;
        Map<Integer, Node> map = new HashMap<>();

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            Node node = map.get(key);
            if (null != node) {
                remove(node);
                setHead(node);
                return node.value;
            }

            return -1;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                node.value = value;
                remove(node);
                setHead(node);
            } else {
                Node newNode = new Node(key, value);
                if (map.size() >= capacity) {
                    map.remove(end.key);
                    remove(end);
                }
                setHead(newNode);
                map.put(key, newNode);
            }
        }

        private void setHead(Node node) {
            node.pre = null;
            node.next = head;
            if (head != null) {
                head.pre = node;
            }
            head = node;

            if (end == null) {
                end = head;
            }
        }

        private void remove(Node node) {
            if (node.next != null) {
                node.next.pre = node.pre;
            } else {
                end = node.pre;
            }

            if (node.pre != null) {
                node.pre.next = node.next;
            } else {
                head = node.next;
            }

            node = null;
        }
    }

    class Node {
        int key;
        int value;
        Node pre;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Leetcode146 ins = new Leetcode146();
        LRUCache cache = ins.new LRUCache(1);
        cache.put(2,1);
        System.out.println(cache.get(2));
        cache.put(3,2);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));

    }
}
