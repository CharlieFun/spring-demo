package com.netease.spring.demo.algorithm;

/**
 * @author fangsida
 * @date 2020/9/15
 */
public class Leetcode684 {
    int[] parents;

    public int[] findRedundantConnection(int[][] edges) {
        if (edges == null || edges.length == 0) {
            return new int[]{0, 0};
        }

        int n = edges.length+1;
        init(n);
        for (int[] edge:edges){
            int x = edge[0], y = edge[1];
            if (!union(x,y)){
                return edge;
            }
        }

        return new int[]{0, 0};
    }

    private boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY){
            return false;
        }

        parents[rootX] = rootY;
        return true;
    }

    private int find(int x) {
        if (parents[x] != x){
            parents[x] = find(parents[x]);
        }

        return parents[x];
    }

    private void init(int n) {
        parents = new int[n];
        for (int i=0;i<n;i++){
            parents[i] = i;
        }
    }
}
