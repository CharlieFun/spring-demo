package com.netease.spring.demo.algorithm;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * 相交链表
 *
 * @author fangsida
 * @date 2020/2/16
 */
public class Leetcode160 {

    //参考：https://leetcode-cn.com/problems/intersection-of-two-linked-lists/solution/tu-jie-xiang-jiao-lian-biao-by-user7208t/
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;

    }
}
