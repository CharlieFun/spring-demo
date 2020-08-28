package com.netease.spring.demo.algorithm;

import java.util.LinkedList;
import java.util.List;

/**
 *     作者：LeetCode
 *     链接：https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/solution/ncha-shu-de-hou-xu-bian-li-by-leetcode/
 *     来源：力扣（LeetCode）
 *     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author fangsida
 * @date 2020/8/28
 */
public class Leetcode590 {

    public List<Integer> postorder(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            output.addFirst(node.val);
            for (Node item : node.children) {
                if (item != null) {
                    stack.add(item);
                }
            }
        }
        return output;
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
