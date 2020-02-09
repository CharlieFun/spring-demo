package com.netease.spring.demo.algorithm;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 * 环形链表 II
 *
 * @author funstar
 * @date 2020/2/9
 */
public class Leetcode142 {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = hasCycle(head);
        if (null == slow){
            return null;
        }

        ListNode node = head;
        while (node != slow){
            node = node.next;
            slow = slow.next;
        }

        return node;
    }

    //快慢指针
    public ListNode hasCycle(ListNode head) {
        if (null == head || null == head.next){
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (true){
            if (slow.next == null){
                return null;
            }

            slow = slow.next;

            if (fast.next == null || fast.next.next == null){
                return null;
            }

            fast = fast.next.next;

            if (slow == fast){
                return slow;
            }
        }
    }
}
