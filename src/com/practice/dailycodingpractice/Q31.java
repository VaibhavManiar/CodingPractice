package com.practice.dailycodingpractice;

/**
 * This problem was asked by Google.
 * <p>
 * The edit distance between two strings refers to the minimum number of character insertions, deletions, and
 * substitutions required to change one string to the other. For example, the edit distance between “kitten” and “sitting” is three:
 * substitute the “k” for “s”, substitute the “e” for “i”, and append a “g”.
 * <p>
 * Given two strings, compute the edit distance between them.
 */
public class Q31 {

    public static int editDistance(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return 0;
        }

        if (str1.isEmpty() && str2.isEmpty()) {
            return 0;
        }

        if (str1.isEmpty() || str2.isEmpty()) {
            return Math.max(str1.length(), str2.length());
        }

        return editDistance(str1.toLowerCase().toCharArray(), str2.toLowerCase().toCharArray());
    }

    private static int editDistance(char[] chArr1, char[] chArr2) {

        int[][] dp = new int[chArr1.length + 1][chArr2.length + 1];
        for (int index = 0; index < dp.length; index++) {
            dp[index][0] = index;
        }

        for (int index = 0; index < dp[0].length; index++) {
            dp[0][index] = index;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (chArr1[i - 1] == chArr2[j - 1]) {
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

        return dp[dp.length - 1][dp[0].length - 1];
    }

    private static void testCase1() {
        String s1 = "";
        String s2 = "";

        int dist = editDistance(s1, s2);
        System.out.println("Test Case Passed : " + (dist == 0));
    }

    private static void testCase2() {
        String s1 = null;
        String s2 = "";

        int dist = editDistance(s1, s2);
        System.out.println("Test Case Passed : " + (dist == 0));
    }

    private static void testCase3() {
        String s1 = null;
        String s2 = null;

        int dist = editDistance(s1, s2);
        System.out.println("Test Case Passed : " + (dist == 0));
    }

    private static void testCase4() {
        String s1 = "";
        String s2 = "abc";

        int dist = editDistance(s1, s2);
        System.out.println("Test Case Passed : " + (dist == 3));
    }

    private static void testCase5() {
        String s1 = "kitten";
        String s2 = "sitting";

        int dist = editDistance(s1, s2);
        System.out.println("Edit Dist : " + dist);
        System.out.println("Test Case Passed : " + (dist == 3));
    }

    private static void testCase6() {
        String s1 = "kitten";
        String s2 = "abs";

        int dist = editDistance(s1, s2);
        System.out.println("Test Case Passed : " + (dist == s1.length()));
    }


    public static void main(String[] args) {
        testCase1();
        testCase2();
        testCase3();
        testCase4();
        testCase5();
        testCase6();
    }

}
