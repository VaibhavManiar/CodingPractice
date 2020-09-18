package com.practice.leetcode;

public class MaxSizePalindromeSubString {

    public static String longestPalindrome(String s) {
        return ManacherAlgorith.findLongestPalindomicSubString(s);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babard"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome("ac"));
        System.out.println(longestPalindrome("aca"));
        System.out.println(longestPalindrome("laca"));
        System.out.println(longestPalindrome("aa"));
        System.out.println(longestPalindrome(""));
        System.out.println(longestPalindrome("bababedffdelm"));

        System.out.println(longestPalindrome("aaabaaaa"));
    }
}