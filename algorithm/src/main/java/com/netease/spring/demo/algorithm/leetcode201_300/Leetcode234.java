package com.netease.spring.demo.algorithm.leetcode201_300;

import com.netease.spring.demo.algorithm.ListNode;

/**
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 * 回文链表
 *
 * @author fangsida
 * @date 2020/2/21
 */
public class Leetcode234 {

    // 反转前半部分
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        ListNode fast = head;
        ListNode cur = head, pre = null;
        while(fast != null && fast.next != null) {
            // 这里的 cur 指针就是 slow 指针，充当了两个作用
            // 一个是快慢指针找中点，一个是反转链表，因为 cur 也是每轮循环走一步
            fast = fast.next.next;
            ListNode nextTemp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextTemp;
        }
        if(fast != null) {
            cur = cur.next;
        }
        while(pre != null) {
            if(pre.val != cur.val) return false;
            pre = pre.next;
            cur = cur.next;
        }
        return true;
    }

}
