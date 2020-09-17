package com.netease.spring.demo.algorithm.leetcode801_900;

import com.netease.spring.demo.algorithm.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fangsida
 * @date 2020/8/20
 */
public class Leetcode894 {

    Map<Integer,List<TreeNode>> cache = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int N) {
        if (!cache.containsKey(N)){
           List<TreeNode> ans = new ArrayList<>();
           if (N==1){
               ans.add(new TreeNode(0));
           }else if (N %2 ==1){
               for (int i=0;i<N;i++ ){
                   for (TreeNode left:allPossibleFBT(i)){
                       for (TreeNode right:allPossibleFBT(N-i-1)){
                           TreeNode root = new TreeNode(0);
                           root.left = left;
                           root.right = right;
                           ans.add(root);
                       }
                   }
               }
           }

           cache.put(N,ans);
        }

        return cache.get(N);
    }
}
