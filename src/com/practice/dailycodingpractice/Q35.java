package com.practice.dailycodingpractice;

import java.util.Collections;

/**
 * This problem was asked by Google.
 * <p>
 * Given an array of strictly the characters 'R', 'G', and 'B', segregate the values of the array so that all the Rs come first, the Gs come second, and the Bs come last. You can only swap elements of the array.
 * <p>
 * Do this in linear time and in-place.
 * <p>
 * For example, given the array ['G', 'B', 'R', 'R', 'B', 'R', 'G'], it should become ['R', 'R', 'R', 'G', 'G', 'B', 'B'].
 */
public class Q35 {

    public static char[] sol(char[] chArr) {
        if (chArr == null || chArr.length == 0) {
            return new char[0];
        }

        int left = 0;
        int right = chArr.length - 1;
        while ( left < right) {
            if(chArr[left] == 'G' && chArr[right] == 'G') {
                swap(chArr, left, left+1);
                swap(chArr, right, right-1);
                if(right-left == 1) {
                    break;
                }
            }

            if(chArr[left] != chArr[right]) {
                swap(chArr, left, right);
            }

            if(chArr[left] == 'R') {
                left++;
            }
            if(chArr[right] == 'B') {
                right--;
            }

        }
        return chArr;
    }

    public static char[] sol1(char[] chArr) {
        if (chArr == null || chArr.length == 0) {
            return new char[0];
        }

        int countR = 0;
        int countG = 0;
        int countB = 0;

        for(char ch  : chArr) {
            if(ch == 'R')
                countR++;
            else if(ch == 'G')
                countG++;
            else
                countB++;
        }
        int index = 0;
        while(index < chArr.length) {
            if(countR > 0) {
                chArr[index] = 'R';
                countR--;
            } else if(countG > 0) {
                chArr[index] = 'G';
                countG--;
            } else if(countB > 0) {
                chArr[index] = 'B';
                countB--;
            }
            index++;
        }

        return chArr;
    }

    private static void swap(char[] chArr, int left, int right) {
        if (left == right)
            return;
        char t = chArr[left];
        chArr[left] = chArr[right];
        chArr[right] = t;
    }

    private static void testCase1() {
        char[] chArr = sol1(new char[]{'G', 'B', 'R', 'R', 'B', 'R', 'G'});
        Collections.singletonList(chArr).forEach(System.out::println);
    }

    private static void testCase2() {
        char[] chArr = sol1(new char[]{'R', 'R', 'G', 'R', 'R', 'R', 'R'});
        Collections.singletonList(chArr).forEach(System.out::println);
    }

    private static void testCase3() {
        char[] chArr = sol1(new char[]{'B', 'B', 'G', 'B', 'B', 'B', 'R'});
        Collections.singletonList(chArr).forEach(System.out::println);
    }

    public static void main(String[] args) {
        testCase1();
        testCase2();
        testCase3();
    }
}
