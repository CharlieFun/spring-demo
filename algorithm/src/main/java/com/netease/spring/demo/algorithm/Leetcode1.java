package com.netease.spring.demo.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 1
 * 两数之和
 *
 * @author funstar
 * @date 2020/2/8
 */
public class Leetcode1 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i<nums.length;i++){
            map.put(nums[i],i);
        }

        int[] res = new int[2];

        for (int i = 0; i<nums.length;i++){
            int num1 = nums[i];
            int num2 = target - num1;

            Integer index = map.get(num2);
            if (null != index && index!=i){
                res[0] = i;
                res[1] = map.get(num2);
                return res;
            }
        }

        return res;
    }
}
