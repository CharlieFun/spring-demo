package com.netease.spring.demo.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author fangsida
 * @date 2020/8/28
 */
public class Leetcode589 {

    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (null == root) {
            return res;
        }

        LinkedList<Node> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            res.add(node.val);
            if (null != node.children && node.children.size() > 0) {
                for (int i = node.children.size() - 1; i >= 0; i--) {
                    if (node.children.get(i) != null) {
                        stack.push(node.children.get(i));
                    }
                }
            }
        }

        return res;

    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
