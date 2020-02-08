package com.netease.spring.demo.algorithm;

/**
 * 合并两个有序链表
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *
 * @author funstar
 * @date 2020/2/8
 */
public class Leetcode21 {


    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode pre = head;
        ListNode cur = null;

        ListNode left = l1;
        ListNode right = l2;
        while (left != null && right != null){
            if (left.val< right.val){
                cur = new ListNode(left.val);
                left = left.next;
            }else{
                cur = new ListNode(right.val);
                right = right.next;
            }

            pre.next = cur;
            pre = cur;
        }

        while (left != null){
            cur = new ListNode(left.val);
            left = left.next;
            pre.next = cur;
            pre = cur;
        }

        while (right != null){
            cur = new ListNode(right.val);
            right = right.next;
            pre.next = cur;
            pre = cur;
        }

        return head.next;
    }
}
