package com.netease.spring.demo.algorithm;

/**
 * 两数相加
 * https://leetcode-cn.com/problems/add-two-numbers/
 *
 * @author funstar
 * @date 2020/2/8
 */
public class Leetcode2 {


    //Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int add = 0;
        ListNode head = new ListNode(0);
        ListNode pre = head;
        ListNode cur;
        while (l1 != null && l2 != null){
            cur = new ListNode(0);
            int sum = l1.val + l2.val + add;
            add = sum / 10;
            cur.val = sum % 10;
            pre.next = cur;
            pre = cur;
            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode node = l1 != null ? l1 : l2;

        if (node != null){
            while(node != null){
                cur = new ListNode(0);
                int sum = node.val + add;
                add = sum / 10;
                cur.val = sum % 10;
                pre.next = cur;
                pre = cur;
                node = node.next;
            }
        }

        if(add != 0){
            cur = new ListNode(0);
            cur.val=add;
            pre.next = cur;
            pre = cur;
        }


        return head.next;
    }
}
