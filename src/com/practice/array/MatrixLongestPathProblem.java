package com.practice.array;

/**
 * Given a n*n matrix where all numbers are distinct, find the maximum length path (starting from any cell) such that all cells along the path are in increasing order with a difference of 1.
 *
 * We can move in 4 directions from a given cell (i, j), i.e., we can move to (i+1, j) or (i, j+1) or (i-1, j) or (i, j-1) with the condition that the adjacent cells have a difference of 1.
 */
public class MatrixLongestPathProblem {
    public static void sol(int[][] mat) {
        int[][] dp = new int[mat.length][mat[0].length];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (dp[i][j] == -1) {
                    sol(i, j, mat, dp);
                }
            }
        }

        System.out.println();
        for (int[] ints : dp) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(ints[j] + " | ");
            }
            System.out.println();
        }
    }

    private static int sol(int i, int j, int[][] mat, int[][] dp) {
        if (i < 0 || i >= dp.length || j < 0 || j >= dp[0].length) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (i > 0 && mat[i - 1][j] == mat[i][j] + 1) {
            dp[i][j] = 1 + sol(i - 1, j, mat, dp);
        }
        if (i < dp.length - 1 && mat[i + 1][j] == mat[i][j] + 1) {
            dp[i][j] = 1 + sol(i + 1, j, mat, dp);
        }
        if (j > 0 && mat[i][j - 1] == mat[i][j] + 1) {
            dp[i][j] = 1 + sol(i, j - 1, mat, dp);
        }
        if (j < dp[0].length - 1 && mat[i][j + 1] == mat[i][j] + 1) {
            dp[i][j] = 1 + sol(i, j + 1, mat, dp);
        }

        return dp[i][j] = Math.max(dp[i][j], 1);
    }

    public static void main(String[] args) {
        sol(new int[][]{{1, 2, 9},
                        {5, 3, 8},
                        {4, 6, 7}});
    }
}
