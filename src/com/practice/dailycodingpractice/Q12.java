package com.practice.dailycodingpractice;

/**
 * <b>Question:</b>
 * There exists a staircase with N steps, and you can climb up either 1 or 2 or 3 steps at a time.
 * Given N, write a function that returns the number of unique ways you can climb the staircase.
 * The order of the steps matters.
 * <p>
 * For example, if N is 4, then there are 5 unique ways:
 * <p>
 * 1, 1, 1, 1
 * 2, 1, 1
 * 1, 2, 1
 * 1, 1, 2
 * 2, 2
 * <p>
 * <p>
 * What if, instead of being able to climb 1 or 2 steps at a time, you could climb any number from a set of positive integers X?
 * For example, if X = {1, 3, 5}, you could climb 1, 3, or 5 steps at a time.
 */
public class Q12 {
    public static int sol(int n) {
        int[] cache = new int[n+1];
        int r = sol(n+1, cache);
        return r;
    }
    private static int sol(int n, int[] cache) {
        if(n <= 1) {
            return Math.max(n, 0);
        }

        if(cache[n-1] != 0) {
            return cache[n-1];
        }
        return cache[n-1] = sol(n-1, cache) + sol(n-2, cache) + sol(n-3, cache);
    }

    public static void main(String[] args) {
        int numberOfStairCases = 4;
        int r = sol(numberOfStairCases);
        System.out.println(r);
    }
}
