package com.netease.spring.demo.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author funstar
 * @date 2020/2/8
 */
public class ReversePrintLinkList {

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        print(list, listNode);
        return list;
    }

    public static void print(List<Integer> list, ListNode listNode) {
        if (null == listNode) {
            return;
        }

        print(list, listNode.next);
        list.add(listNode.val);
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;

        ArrayList<Integer> list = printListFromTailToHead(node1);
        System.out.println(list);

    }
}
