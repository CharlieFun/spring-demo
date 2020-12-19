package com.netease.spring.demo.algorithm.leetcode201_300;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * 最长上升子序列
 *
 * @author fangsida
 * @date 2020/2/23
 */
public class Leetcode300 {

    public static void main(String[] args) {
        int[] arr = {10, 9, 2, 5, 3, 17, 101, 14, 15};
        Leetcode300 ins = new Leetcode300();
        System.out.println(ins.lengthOfLIS(arr));
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    /**
     * 改了下楼主的for循环，如果num比tails里已更新的最后一个都大（或者第一次添加），
     * 直接往tails后添加num；否则通过二分查找找出tails里刚好比num大，
     * 但前一个比num小（或没有前一个）的位置，并用num替换掉原来的值。这样可能比较好理解一点。
     * @param nums
     * @return
     */
    public int lengthOfLIS2(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for(int num : nums) {
            if(res==0||num>tails[res-1]){
                tails[res++]=num;
            }else{
                int i = 0, j = res;
                while(i < j) {
                    int mid = (i + j) / 2;
                    if(tails[mid] < num) i = mid + 1;
                    else j = mid;
                }
                tails[i] = num;
            }

        }
        return res;
    }
}
