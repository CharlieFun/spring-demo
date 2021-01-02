package com.netease.spring.demo.algorithm.leetcode801_900;

import java.util.HashSet;
import java.util.Set;

/**
 * @author fangsida
 * @date 2021/1/1
 */
public class Leetcode898 {

    public int subarrayBitwiseORs(int[] A) {

        Set<Integer> set = new HashSet<Integer>();
        //prebit记录截止到当前能生成的最大值
        int prebit = 0;
        for (int i = 0; i < A.length; i++) {
            //更新当前最大值
            prebit |= A[i];
            int currbit = 0;
            for(int j = i; j >= 0; j--) {
                currbit |= A[j];
                set.add(currbit);
                //剪枝，因为或操作是递增的，一旦到了最大值，直接退出当前循环
                if (currbit == prebit) {
                    break;  // 所有bit都置位则终止循环
                }
            }

        }
        return set.size();

    }
}
