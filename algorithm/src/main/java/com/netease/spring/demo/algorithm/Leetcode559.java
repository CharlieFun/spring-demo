package com.netease.spring.demo.algorithm;

import java.util.List;

/**
 * @author fangsida
 * @date 2020/8/27
 */
public class Leetcode559 {
    public int maxDepth(Node root) {
        if (null == root){
            return 0;
        }else if (root.children == null || root.children.size()==0){
            return 1;
        }

        int depth = Integer.MIN_VALUE;
        for (Node child:root.children){
            depth = Math.max(depth,maxDepth(child));
        }

        return depth+1;
    }


// Definition for a Node.
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
