package com.netease.spring.demo.algorithm.leetcode1_100;

import com.netease.spring.demo.algorithm.ListNode;

/**
 * 删除链表的倒数第N个节点
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * 1->2->3->4->5
 *
 * @author funstar
 * @date 2020/2/8
 */
public class Leetcode19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode node = head;
        while (node != null) {
            len++;
            node = node.next;
        }

        if (len == 1){
            return null;
        }

        if (len == n){
            return head.next;
        }

        int index = 1;
        int target = len -n;
        node = head;
        while (index < target){
            index++;
            node = node.next;
        }

        node.next = node.next.next;
        return head;
    }
}
