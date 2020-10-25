package com.netease.spring.demo.algorithm.leetcode601_700;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fangsida
 * @date 2020/10/25
 */
public class Leetcode638 {

    int min = 0;

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        for (int i = 0; i < price.size(); i++) {
            min += price.get(i) * needs.get(i);
        }

        dfs(price, special, needs, 0, min);
        return min;
    }

    private void dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int index, int cost) {
        if (index >= special.size()) {
            return;
        }

        List<Integer> curSpecial = special.get(index);
        int tmp = 0;
        //是否能选该礼包
        boolean can = true;
        List<Integer> newNeeds = new ArrayList<>();

        //遍历某个礼包
        for (int i = 0; i < curSpecial.size() - 1; i++) {

            if (curSpecial.get(i) > needs.get(i)) {
                can = false;
                break;
            }
            newNeeds.add(needs.get(i) - curSpecial.get(i));
            tmp += price.get(i) * curSpecial.get(i);

        }

        if (can) {
            int newCost = cost - tmp + curSpecial.get(curSpecial.size() - 1);
            min = Math.min(min, newCost);
            dfs(price, special, newNeeds, index, newCost);
        }

        dfs(price, special, needs, index + 1, cost);
    }
}
