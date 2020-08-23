package com.netease.spring.demo.algorithm;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author fangsida
 * @date 2020/8/22
 */
public class Leetcode116 {

    public Node connect(Node root) {
        if (root == null){
            return null;
        }
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()){
            int size = stack.size();

            for (int i=0;i<size;i++){
                Node node = stack.pop();

                if (i<size-1){
                    node.next = stack.peek();
                }

                if (node.left != null) {
                    stack.addLast(node.left);
                }
                if (node.right != null) {
                    stack.addLast(node.right);
                }


            }
        }

        return root;

    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
