package com.netease.spring.demo.study.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * 自定义实现Lru，基于HashMap和双向链表
 *
 * @author fangsida
 * @date 2020/5/5
 */
public class LruMySelf<K, V> {

    private int size;

    private Map<K, Node> cache;

    private Node head;

    private Node tail;

    public LruMySelf(int size) {
        this.size = size;
        this.cache = new HashMap<>();
        this.head = null;
        this.tail = null;
    }

    public void put(K key, V value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            moveToTail(node);
        } else {
            Node node = new Node(key, value);
            cache.put(key, node);
            addToTail(node);

            if (cache.size() > size) {
                Node oldHead = removeHead();
                cache.remove(oldHead.key);
            }
        }
    }

    private Node removeHead() {
        if (null == head) {
            return null;
        }
        Node node = head;
        System.out.println("最近最少使用的key=" + node.key);
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.pre = null;
        }

        return node;
    }

    private void addToTail(Node node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.pre = tail;
            node.next = null;
            tail = node;
        }

    }

    private void moveToTail(Node node) {
        if (node == null || node == tail) {
            return;
        }

        if (node == head) {
            head = head.next;
            head.pre = null;
        } else {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        tail.next = node;
        node.pre = tail;
        node.next = null;
        tail = node;
    }

    public V get(K key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            moveToTail(node);
            return node.value;
        } else {
            return null;
        }
    }

    public String toString() {
        if (head == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder();
        builder.append("{");
        Node node = head;
        while (node != null) {
            builder.append(node.key)
                    .append("=")
                    .append(node.value)
                    .append(",");

            node = node.next;
        }

        return builder.substring(0, builder.length() - 1) + "}";
    }

    private class Node {
        private Node pre;

        private Node next;

        private K key;

        private V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.pre = null;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        LruMySelf<String,String> map = new LruMySelf<>(5);
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
