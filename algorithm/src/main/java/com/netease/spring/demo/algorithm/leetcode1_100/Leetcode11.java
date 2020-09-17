package com.netease.spring.demo.algorithm.leetcode1_100;

/**
 * 盛最多水的容器
 * https://leetcode-cn.com/problems/container-with-most-water/
 *
 * @author funstar
 * @date 2020/2/8
 */
public class Leetcode11 {

    public int maxArea(int[] height) {
        int res = 0;
        for (int i=0;i<height.length-1;i++){
            for (int j=i+1;j<height.length;j++){
                int area = Math.min(height[i],height[j]) * (j-i);
                res = Math.max(area,res);
            }

        }

        return res;
    }
}
