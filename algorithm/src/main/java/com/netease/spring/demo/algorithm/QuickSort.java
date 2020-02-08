package com.netease.spring.demo.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 快排
 * leetcode 912
 * @author funstar
 * @date 2020/2/7
 */
public class QuickSort {
    private static int count;

    public static List<Integer> sortArray(int[] nums) {
        quickSort(nums, 0, nums.length-1);
        List<Integer> list = new ArrayList<>();
        for(int num:nums){
            list.add(num);
        }
        return list;
    }

    public static void quickSort(int[] nums, int left, int right){
        if(left >= right){
            return;
        }

        int i = left;
        int j = right;
        int mid = nums[left];
        while(i<j){
            while(j> i && nums[j] >= mid){
                j--;
            }

            while(i< j && nums[i] <= mid){
                i++;
            }

            if(i<j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }

        }
        nums[left] = nums[i];
        nums[i] = mid;

        quickSort(nums,left,i-1);
        quickSort(nums,i+1,right);

    }

    public static void main(String[] args) {
        int[] arr = new int[]{-2,3,-5};
        List<Integer> list = sortArray(arr);
        System.out.println(list);
    }
}
