package com.netease.spring.demo.algorithm.leetcode301_400;

/**
 * @author fangsida
 * @date 2020/9/28
 */
public class Leetcode357 {

    public int countNumbersWithUniqueDigits(int n) {
        if(n==0) return 1;

        int[] dp = new int[n+1];
        dp[1] = 10;
        dp[2] = 91;
        for (int i=3;i<n+1;i++){
            dp[i] = dp[i-1] + cal(i,10) - cal(i-1,9);
        }


        return dp[n];
    }

    private int cal(int n,int num) {
        int res = 1;

        for (int i=0;i<n;i++){
            res = res*(num-i);
        }

        return res;
    }

    public static void main(String[] args) {
        Leetcode357 ins = new Leetcode357();
        System.out.println(ins.countNumbersWithUniqueDigits(3));
    }
}
