package com.netease.spring.demo.algorithm.leetcode1001_1100;

import com.netease.spring.demo.algorithm.leetcode1_100.Leetcode1;

import java.util.Arrays;

/**
 * @author fangsida
 * @date 2021/1/2
 */
public class Leetcode1048 {
    public int longestStrChain(String[] words) {
        int n = words.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);

        Arrays.sort(words,(a,b) -> a.length()-b.length());

        for(int i = 1; i< n;i++){
            for(int j=0;j<i;j++){
                if(isSub(words[j],words[i])){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }

        int res = 0;
        for(int i = 0; i< n;i++){
            res = Math.max(res,dp[i]);
        }
        return res;
    }

    private boolean isSub(String a, String b){
        if(a.length()+1 != b.length()){
            return false;
        }

        boolean used = false;
        int i=0;
        int j=0;
        while (i<a.length() && j<b.length()){
            if (a.charAt(i) == b.charAt(j)){
                i++;
                j++;
            }else{
                if (!used){
                    j++;
                    used = true;
                }else{
                    return false;
                }
            }
        }

        return (i == a.length() && j == b.length()) ||
                (i == a.length() && (j == b.length()-1) && !used);
    }

    public static void main(String[] args) {
        Leetcode1048 ins = new Leetcode1048();
        String[] arr = {"xbc","pcxbcf","xb","cxbc","pcxbc"};
        System.out.println(ins.longestStrChain(arr));
    }
}
