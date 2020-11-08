package com.netease.spring.demo.algorithm.leetcode701_800;

/**
 * @author fangsida
 * @date 2020/11/5
 */
public class Leetcode714 {

    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;

        Leetcode714 instance = new Leetcode714();
        System.out.println(instance.maxProfit(prices, fee));
    }

    /**
     * 自己的解法
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit_0(int[] prices, int fee) {
        int len = prices.length;
        int[] dp = new int[len + 1];

        for (int i = 2; i <= len; i++) {
            //dp[i]卖出
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], dp[j - 1] + prices[i - 1] - prices[j - 1] - fee);
            }

            //dp[i]不买也不卖
            dp[i] = Math.max(dp[i], dp[i - 1]);
        }

        return dp[len];
    }

    /**
     * leetcode官方答案
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit(int[] prices, int fee) {
        int cash = 0, hold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
        }
        return cash;
    }
}
