package com.netease.spring.demo.algorithm.leetcode801_900;

/**
 * @author fangsida
 * @date 2020/12/31
 */
public class Leetcode813 {
    public double largestSumOfAverages(int[] A, int K) {
        int[] sumArr =calculateSum(A);

        double[][] dp = new double[A.length+1][K+1];
        for (int i=1;i<=A.length;i++){
            dp[i][1] = sumArr[i]/i;
        }

        for (int i=1;i<=A.length;i++){
            for (int k=2;k<=K && k<=i;k++){
                for (int j=0;j<i;j++){
                    dp[i][k] = Math.max(dp[i][k],dp[j][k-1] + (sumArr[i]-sumArr[j])*1.0/(i-j));
                }
            }
        }

        return dp[A.length][K];
    }

    private int[] calculateSum(int[] a) {
        int[] sumArr = new int[a.length+1];

        for (int i = 1; i <= a.length; i++) {
            sumArr[i] = sumArr[i - 1] + a[i-1];
        }
        return sumArr;
    }

    /**
     * 回溯法，超时了
     */
    public class BackTrack {
        double res = Double.MIN_VALUE;

        public double largestSumOfAverages(int[] A, int K) {
            if (A == null || A.length < K) {
                return 0.0;
            }

            double score = 0.0;

            int[] sumArr = calculateSum(A);


            backTrack(sumArr, K, 0, score);
            return res;
        }

        private int[] calculateSum(int[] a) {
            int[] sumArr = new int[a.length];

            sumArr[0] = a[0];
            for (int i = 1; i < a.length; i++) {
                sumArr[i] = sumArr[i - 1] + a[i];
            }
            return sumArr;
        }

        private void backTrack(int[] sumArr, int k, int start, double score) {
            if (start >= sumArr.length) {
                return;
            }
            if (sumArr.length - start < k) {
                return;
            }

            if (k == 1) {
                double temp = average(sumArr, start, sumArr.length - 1);
                score += temp;
                res = Math.max(res, score);
                return;
            }


            for (int i = 1; i < sumArr.length - start; i++) {
                double temp = average(sumArr, start, start + i - 1);
                score += temp;
                backTrack(sumArr, k - 1, start + i, score);
                score -= temp;
            }
        }

        private double average(int[] sumArr, int start, int end) {
            if (start == 0) {
                return 1.0 * sumArr[end] / (end + 1);
            } else {
                return 1.0 * (sumArr[end] - sumArr[start - 1]) / (end - start + 1);
            }

        }
    }

    public static void main(String[] args) {
        int[] A = {9,1,2,3,9};
        Leetcode813 ins = new Leetcode813();
        System.out.println(ins.largestSumOfAverages(A,3));
    }
}
