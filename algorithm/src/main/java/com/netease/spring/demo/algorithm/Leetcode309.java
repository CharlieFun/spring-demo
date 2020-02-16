package com.netease.spring.demo.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * 最佳买卖股票时机含冷冻期
 *
 * @author funstar
 * @date 2020/2/9
 */
public class Leetcode309 {
    /**
     * 思路：动态规划，格式：
     * 1.确定目标值含义（确定要填的表格含义）
     * 2.找到状态转移方程（表格值的计算方式，动态规划的问题，后面的值可以从历史值计算得出）
     * 3.初始化表格（初始化表格，然后根据1、2往后进行计算）
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (null == prices || prices.length <= 1) {
            return 0;
        }

        //初始化
        List<Integer> dp = new ArrayList<>();
        dp.add(0);

        for (int i = 1; i < prices.length; i++) {
            //如果最后一天不卖股票，dp[i] =dp[i-1]
            int maxProfit = dp.get(i - 1);
            //如果最后一天卖股票，根据这笔操作买股票的时间进行分类，买入时间为j
            for (int j = 0; j < i; j++) {
                //j<3时，由于卖出后第二天不能买入，所以j之前没有股票操作，即总共只有一次操作
                if (j < 3) {
                    maxProfit = Math.max(maxProfit, prices[i] - prices[j]);
                    //j>3时，j-2之前和这次的交易是独立的，所以还要加上j-2之前的利润
                } else {
                    maxProfit = Math.max(maxProfit, dp.get(j - 2) + prices[i] - prices[j]);
                }
            }
            dp.add(maxProfit);
        }

        return dp.get(prices.length - 1);
    }
}
