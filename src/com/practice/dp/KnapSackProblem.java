package com.practice.dp;

/**
 * 0/1 Knapsack Problem - Given items of certain weights/values and maximum allowed weight
 * how to pick items to pick items from this set to maximize sum of value of items such that
 * sum of weights is less than or equal to maximum allowed weight.
 * <p>
 * Time complexity - O(W*total items)
 */
public class KnapSackProblem {
    public static void sol(int[] V, int[] WT, int C) {
        int[][] dp = new int[WT.length][C + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i < dp.length; i++) {
            int wt = WT[i];
            int v = V[i];
            for (int j = 1; j < dp[i].length; j++) {
                if (i == 0) {
                    if (wt > j) {
                        dp[i][j] = dp[i][j - 1];
                    } else {
                        dp[i][j] = v;
                    }
                } else {
                    if (wt > j) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = Math.max(v + dp[i - 1][j - wt], dp[i - 1][j]);
                    }
                }
            }
        }

        System.out.println();
        for (int[] arr : dp) {
            System.out.print(" | ");
            for (int a : arr) {
                System.out.print(a + " | ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public static void main(String[] args) {
        sol(new int[]{1, 4, 5, 7}, new int[]{2, 3, 4, 5}, 7);
    }
}
