package com.practice.dailycodingpractice;

import java.util.ArrayList;
import java.util.List;

/**
 * This problem was asked by Google.
 * <p>
 * Given an array of integers and a number k, where 1 <= k <= length of the array, compute the maximum values of each subarray of length k.
 * <p>
 * For example, given array = [10, 5, 2, 7, 8, 7] and k = 3, we should get: [10, 7, 8, 8], since:
 * <p>
 * 10 = max(10, 5, 2)
 * 7 = max(5, 2, 7)
 * 8 = max(2, 7, 8)
 * 8 = max(7, 8, 7)
 * Do this in O(n) time and O(k) space. You can modify the input array in-place and you do not need to store the results. You can simply print them out as you compute them.
 */
public class Q18 {

    public static List<Integer> sol(int[] arr, int k) {
        List<Integer> l = new ArrayList<>();
        int tcount = 0;
        double mul = 1;
        int max = Integer.MIN_VALUE;
        for (int index = 0; index <  arr.length; index++) {
            int val = arr[index];
            if (tcount < k) {
                tcount++;
                mul *= val;
                if (max < val) {
                    max = val;
                }
            } else {
                if (l.size() <= 0) {
                    l.add(max);
                }
                double div = (mul / arr[index-k]);
                if (div / val <= val) {
                    max = val;
                }
                mul = (mul / arr[index-k]) * val;
                l.add(max);
            }
        }
        return l;
    }

    public static void main(String[] args) {
        sol(new int[]{10, 5, 2, 7, 8, 7}, 3).forEach(System.out::println);
    }

}
