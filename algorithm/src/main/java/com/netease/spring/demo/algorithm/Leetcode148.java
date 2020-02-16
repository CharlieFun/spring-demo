package com.netease.spring.demo.algorithm;

/**
 * https://leetcode-cn.com/problems/sort-list/
 * 排序链表
 *
 * @author fangsida
 * @date 2020/2/16
 */
public class Leetcode148 {
    //其实不符合要求，因为递归会占用O(logn)的空间复杂度，不是常数级别
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode mid = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        ListNode newHead = new ListNode(0);
        ListNode temp = newHead;

        while (left != null && right != null) {
            if (left.val < right.val) {
                temp.next = left;
                left = left.next;
            } else {
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }

        temp.next = left != null ? left : right;
        return newHead.next;
    }
}
