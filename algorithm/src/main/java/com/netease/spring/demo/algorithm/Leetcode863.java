package com.netease.spring.demo.algorithm;

import java.util.*;

/**
 * @author fangsida
 * @date 2020/9/16
 */
public class Leetcode863 {

    Map<TreeNode,TreeNode> parents = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        depScan(root,null);

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(null);
        queue.add(target);

        Set<TreeNode> seen = new HashSet<>();
        seen.add(null);
        seen.add(target);

        int dist = 0;

        List<Integer> ans = new ArrayList<>();

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(null == node){
                if (dist == K){
                    while (!queue.isEmpty()) {
                        ans.add(queue.poll().val);

                    }
                    return ans;

                }
                dist++;
                queue.add(null);
            }else{
                seen.add(node);
                if (!seen.contains(node.left)){
                    queue.add(node.left);
                }

                if (!seen.contains(node.right)){
                    queue.add(node.right);

                }

                if (!seen.contains(parents.get(node))){
                    queue.add(parents.get(node));

                }
            }
        }

        return ans;
    }

    private void depScan(TreeNode node, TreeNode parent) {
        if (node !=null) {
            parents.put(node, parent);
            depScan(node.left, node);
            depScan(node.right, node);
        }
    }
}
