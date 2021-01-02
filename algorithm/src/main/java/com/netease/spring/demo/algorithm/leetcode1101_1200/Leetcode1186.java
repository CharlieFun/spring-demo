package com.netease.spring.demo.algorithm.leetcode1101_1200;

/**
 * @author fangsida
 * @date 2021/1/2
 */
public class Leetcode1186 {

    public int maximumSum(int[] arr) {
        int len = arr.length;
        int[] f = new int[len];
        int[] g = new int[len];
        int res = arr[0];
        f[0] = arr[0];
        g[0] = -20000;
        for(int i=1;i<len;i++){
            f[i] = Math.max(f[i-1]+arr[i],arr[i]);//其实就是f(i-1)是否<0
            g[i] = Math.max(g[i-1]+arr[i],f[i-1]);
            res = Math.max(res,Math.max(f[i],g[i]));
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,-2,0,3};
        Leetcode1186 ins = new Leetcode1186();
        System.out.println(ins.maximumSum(arr));
    }
}
