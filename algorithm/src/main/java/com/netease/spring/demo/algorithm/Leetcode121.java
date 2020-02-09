package com.netease.spring.demo.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * 买卖股票的最佳时机
 *
 * @author funstar
 * @date 2020/2/9
 */
public class Leetcode121 {

    public int maxProfit(int[] prices) {
        if (null == prices || prices.length <= 1) {
            return 0;
        }

        List<Integer> dp = new ArrayList<>();
        dp.add(0);

        for (int i = 1; i < prices.length; i++) {
            int sub = prices[i] - findMin(prices, 0, i);
            int maxI = Math.max(dp.get(i - 1), sub);
            dp.add(maxI);
        }

        return dp.get(prices.length - 1);

    }

    private int findMin(int[] prices, int start, int end) {
        int min = prices[start];

        for (int i = start; i < end; i++) {
            min = Math.min(min, prices[i]);
        }

        return min;
    }
}
