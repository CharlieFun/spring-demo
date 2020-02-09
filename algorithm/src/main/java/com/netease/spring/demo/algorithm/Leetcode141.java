package com.netease.spring.demo.algorithm;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle/
 * 环形链表
 *
 * @author funstar
 * @date 2020/2/9
 */
public class Leetcode141 {

    //快慢指针
    public boolean hasCycle(ListNode head) {
        if (null == head || null == head.next){
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (true){
            if (slow.next == null){
                return false;
            }

            slow = slow.next;

            if (fast.next == null || fast.next.next == null){
                return false;
            }

            fast = fast.next.next;

            if (slow == fast){
                return true;
            }
        }
    }
}
