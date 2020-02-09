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
    public int maxProfit(int[] prices) {
        if (null == prices || prices.length <= 1) {
            return 0;
        }

        List<Integer> dp = new ArrayList<>();
        dp.add(0);

        for (int i = 1; i < prices.length; i++) {
            int maxProfit = dp.get(i - 1);
            for (int j = 0; j < i; j++) {
                if (j < 3) {
                    maxProfit = Math.max(maxProfit, prices[i] - prices[j]);
                } else {
                    maxProfit = Math.max(maxProfit, dp.get(j - 2) + prices[i] - prices[j]);
                }
            }
            dp.add(maxProfit);
        }

        return dp.get(prices.length - 1);
    }
}
