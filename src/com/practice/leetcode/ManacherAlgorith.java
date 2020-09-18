package com.practice.leetcode;

/**
 * This Algorithm is used for finding the longest Palindromic sub string in a given string in O(n) time.
 * For Ex:
 */
public class ManacherAlgorith {
    public ManacherAlgorith() {
    }

    public static String findLongestPalindomicSubString(String str) {
        String preProcessedString = preprocess(str);
        int[] p1 = calMaxLengthArr(preProcessedString);

        int centerIndex = maxValueIndex(p1);
        int maxLen = p1[centerIndex];
        return removeAllCharFromString(preProcessedString.substring(centerIndex-maxLen, centerIndex + maxLen), '#');
    }

    // Mugup this code
    private static int[] calMaxLengthArr(String str) {
        int C = 0;
        int R = 0;
        int[] p = new int[str.length()];

        for (int index = 0; index < str.length(); index++) {
            int iMirror = C - (index - C);

            if (R > index) {
                p[index] = Math.min(R - index, p[iMirror]);
            } else {
                p[index] = 0;
            }

            while ((index + 1 + p[index]) < str.length() && (index - 1 - p[index]) >= 0 &&
                    str.charAt(index + 1 + p[index]) == str.charAt(index - 1 - p[index])) {
                p[index]++;
            }

            if (R < (index + p[index])) {
                R = index + p[index];
                C = index;
            }
        }
        return p;
    }

    private static String removeAllCharFromString(String str, char ch) {
        StringBuilder sb = new StringBuilder();
        for(char c : str.toCharArray()) {
            if(c != ch) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private static int maxValueIndex(int[] arr) {
        int maxIndex = -1;
        int maxValue = Integer.MIN_VALUE;
        for(int index = 0; index < arr.length; index++) {
            if(arr[index] > maxValue) {
                maxValue = arr[index];
                maxIndex = index;
            }
        }
        return maxIndex;
    }

    private static String preprocess(String str) {
        StringBuilder preProcessedString = new StringBuilder("#");
        for (char ch : str.toCharArray()) {
            preProcessedString.append(ch).append("#");
        }
        return preProcessedString.toString();
    }

    public static void main(String[] args) {
        System.out.println(findLongestPalindomicSubString("babard"));
        System.out.println(findLongestPalindomicSubString("cbbd"));
        System.out.println(findLongestPalindomicSubString("a"));
        System.out.println(findLongestPalindomicSubString("ac"));
        System.out.println(findLongestPalindomicSubString("aca"));
        System.out.println(findLongestPalindomicSubString("laca"));
        System.out.println(findLongestPalindomicSubString("aa"));
        System.out.println(findLongestPalindomicSubString(""));
        System.out.println(findLongestPalindomicSubString("bababedffdelm"));

        System.out.println(findLongestPalindomicSubString("aaabaaaa"));
        System.out.println(findLongestPalindomicSubString("aaabaaaa"));
    }
}
