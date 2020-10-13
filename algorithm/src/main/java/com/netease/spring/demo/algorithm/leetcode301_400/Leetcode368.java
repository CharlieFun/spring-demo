package com.netease.spring.demo.algorithm.leetcode301_400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author fangsida
 * @date 2020/10/12
 */
public class Leetcode368 {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums.length == 0){
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        int n = nums.length;

        List[] dp = new List[n];

        dp[0] = new ArrayList();
        dp[0].add(nums[0]);
        List<Integer> ans = dp[0];

        for(int i=1;i<n;i++){
            dp[i] = new ArrayList();
            dp[i].add(nums[i]);

            for (int j=0;j<i;j++){
                if (nums[i] % nums[j] == 0 && (dp[i].size() < dp[j].size()+1)){
                    dp[i] = new ArrayList(dp[j]);
                    dp[i].add(nums[i]);
                }
            }

            if(dp[i].size() > ans.size()){
                ans = dp[i];
            }
            
        }

        return ans;
    }
}
