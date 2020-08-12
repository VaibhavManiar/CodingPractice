package com.practice.dp;

/**
 * Longest common subsequence
 */
public class LCS {
    public static String find(char[] a, char[] b) {
        int[][] dp = new int[a.length + 1][b.length + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (a[i - 1] == b[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }


        for (int i = 0; i < dp.length; i++) {
            System.out.print(" | ");
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " | ");
            }
            System.out.println();
        }
        System.out.println();

        StringBuilder str = new StringBuilder();
        int i = dp.length - 1;
        int j = dp[0].length - 1;

        while (i > 0 && j > 0) {
            if (dp[i - 1][j] != dp[i][j - 1] && (dp[i - 1][j - 1] + 1) == dp[i][j]) {
                str.insert(0, a[i - 1]);
                i--;;
                j--;;
            } else {
                if (dp[i - 1][j] >= dp[i][j - 1]) {
                    i--;;
                } else {
                    j--;
                }
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(find("ABCDEF".toCharArray(), "AEDFHR".toCharArray()));
    }
}
