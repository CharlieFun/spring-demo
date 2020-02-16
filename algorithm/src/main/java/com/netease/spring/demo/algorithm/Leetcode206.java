package com.netease.spring.demo.algorithm;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * 反转链表
 * @author fangsida
 * @date 2020/2/16
 */
public class Leetcode206 {

    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode cur = head;

        while (cur !=null){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }
}
