package com.practice.dp;

/**
 * https://www.youtube.com/watch?v=We3YDTzNXEk
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/EditDistance.java
 */
public class StringEditDistance {
    public static int find(char[] a, char[] b) {
        int[][] dp = new int[a.length + 1][b.length + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (a[i - 1] == b[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " | ");
            }
            System.out.println();
        }
        printOperations(a, b, dp);
        return dp[dp.length - 1][dp[0].length - 1];
    }


    /**
     * Backtracking method
     */
    private static void printOperations(char[] a, char[] b, int[][] dp) {
        int i = dp.length - 1;
        int j = dp[0].length - 1;
        while (i > 0 && j > 0) {
            if (a[i - 1] == b[j - 1]) {
                i--;
                j--;
            } else if (dp[i][j] == dp[i - 1][j - 1] + 1) {
                System.out.println("Edit : " + a[i - 1] + " to " + b[j - 1]);
                i--;
                j--;
            } else if (dp[i][j] == dp[i - 1][j] + 1) {
                System.out.println("Delete in string1 : " + b[j - 1]);
                i--;
            } else if (dp[i][j] == dp[i][j - 1] + 1) {
                System.out.println("Delete in string2 : " + b[j - 1]);
                j--;
            } else {
                System.out.println("Something went wrong. " + a[i - 1] + " , " + b[j - 1]);
            }
        }
    }

    private static void testCase1() {
        String str1 = "azced";
        String str2 = "abcdef";
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(find(str1.toCharArray(), str2.toCharArray()));
    }

    private static void testCase2() {
        String str1 = "kitten";
        String str2 = "sitting";
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(find(str1.toCharArray(), str2.toCharArray()));
    }

    public static void main(String[] args) {
        //testCase1();
        testCase2();
    }
}
