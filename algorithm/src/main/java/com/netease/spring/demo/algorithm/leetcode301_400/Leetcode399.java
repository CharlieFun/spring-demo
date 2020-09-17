package com.netease.spring.demo.algorithm.leetcode301_400;

import java.util.*;

/**
 * @author fangsida
 * @date 2020/3/29
 */
public class Leetcode399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = new HashMap<String, Map<String, Double>>();
        int i, len = equations.size(), len1 = queries.size();
        for (i = 0; i < len; i++) {
            String s1 = equations.get(i).get(0), s2 = equations.get(i).get(1);
            if (!map.containsKey(s1)) {
                Map<String, Double> m = new HashMap<String, Double>();
                m.put(s2, values[i]);
                map.put(s1, m);
            } else {
                map.get(s1).put(s2, values[i]);
            }
            if (!map.containsKey(s2)) {
                Map<String, Double> m = new HashMap<String, Double>();
                m.put(s1, 1 / values[i]);
                map.put(s2, m);
            } else {
                map.get(s2).put(s1, 1 / values[i]);
            }
        }

        double ans[] = new double[len1];
        for (i = 0; i < len1; i++) {
            String source = queries.get(i).get(0), target = queries.get(i).get(1);
            Set<String> visited = new HashSet<String>();
            ans[i] = find(map, visited, source, target, 1);
        }
        return ans;
    }


    double find(Map<String, Map<String, Double>> map, Set<String> visited, String source, String target, double rate) {
        if (!map.containsKey(source)) {
            return -1;
        }
        Map<String, Double> link = map.get(source);
        if (link.containsKey(target)) {
            return link.get(target) * rate;
        } else {
            for (String nebor : link.keySet()) {
                if (!visited.contains(nebor)) {
                    visited.add(nebor);
                    double temp = find(map, visited, nebor, target, rate * link.get(nebor));
                    if (temp != -1) {
                        return temp;
                    }
                }
            }
        }
        return -1;
    }
}
