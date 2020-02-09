package com.netease.spring.demo.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 * 括号生成
 *
 * @author funstar
 * @date 2020/2/9
 */
public class Leetcode22 {

    //思路，动态规划,状态转移方程：
    // dp[i] = "("+dp[j]+") + dp[k]", i = j+k+1
    public List<String> generateParenthesis(int n) {
        if (0 == n) {
            return new ArrayList<>();
        }

        List<List<String>> dp = new ArrayList<>();

        List<String> dp0 = new ArrayList<>();
        dp0.add("");
        dp.add(dp0);

        for (int i = 1; i <= n; i++) {
            List<String> dpi = new ArrayList<>();
            for (int j = 0; j <= i - 1; j++) {
                List<String> dpj = dp.get(j);
                List<String> dpk = dp.get(i - j - 1);
                for (String sj : dpj) {
                    for (String sk : dpk) {
                        dpi.add("(" + sj + ")" + sk);
                    }
                }
            }
            dp.add(dpi);
        }

        return dp.get(n);

    }
}
