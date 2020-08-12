package com.practice.array;

/**
 * Daily Coding Problem: Problem #9
 *
 * Given a list of integers, write a function that returns the largest sum of non-adjacent numbers.
 * Numbers can be 0 or negative.
 */
public class MaxSumOfNonAdjacentValues {

    public static long sum(int[] arr) {
        int i=0;
        long sum1 = 0;
        long sum2 = 0;
        while(i < arr.length) {
            if(arr[i] > 0) {
                sum1 += arr[i];
                i++;
            }
            i++;
        }
        i=1;
        while(i < arr.length) {
            if(arr[i] > 0) {
                sum2 += arr[i];
                i++;
            }
            i++;
        }
        return Math.max(sum1, sum2);
    }

    public static void main(String[] args) {
        long maxSum = sum(new int[] {2,13,6,1,-1,5,1,13});
        System.out.println(maxSum);
    }

}
