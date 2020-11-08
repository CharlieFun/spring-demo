package com.netease.spring.demo.algorithm.leetcode801_900;

import java.util.Arrays;

/**
 * 作者：suan-tou-wang-ba
 * 链接：https://leetcode-cn.com/problems/minimum-swaps-to-make-sequences-increasing/solution/leetcode-801-wo-gan-jio-ying-gai-jiang-de-hen-tou-/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @author fangsida
 * @date 2020/11/8
 */
public class Leetcode801 {
    public int minSwap(int[] A, int[] B) {
        int len = A.length;
        //不交换 i 的情况
        int[] keep = new int[len];
        //交换 i 的情况
        int[] swap = new int[len];
        Arrays.fill(keep, Integer.MAX_VALUE);
        Arrays.fill(swap, Integer.MAX_VALUE);
        //初始条件，第 0 个位置不交换，次数为 0，第 0 个位置交换，次数为 1
        keep[0] = 0;
        swap[0] = 1;
        for (int i = 1; i < len; i++) {
            /*
            如果满足两种情况
            i 交换的情况下，可以有 i - 1 不交换 和 i - 1 交换，选择最优情况
            i 不交换的情况下，可以有 i - 1 交换和 i - 1 不交换，选择最优情况
            */
            if ((A[i] > A[i - 1] && B[i] > B[i - 1]) && (A[i] > B[i - 1] && B[i] > A[i - 1])) {
                //i 不交换
                keep[i] = Math.min(keep[i - 1], swap[i - 1]);
                //i 交换
                swap[i] = Math.min(swap[i - 1], keep[i - 1]) + 1;
                continue;
            }

            if (A[i] > A[i - 1] && B[i] > B[i - 1]) {
                //i 不交换
                keep[i] = keep[i - 1];
                //i 交换，那么意味着 i - 1 也交换
                swap[i] = swap[i - 1] + 1;
            }

            if (A[i] > B[i - 1] && B[i] > A[i - 1]) {
                //i 不交换，那么就是交换 i - 1
                keep[i] = swap[i - 1];
                //i 交换，那么就是 i - 1 不交换
                swap[i] = keep[i - 1] + 1;
            }
        }
        return Math.min(keep[len - 1], swap[len - 1]);
    }

}
