package com.practice.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Integer inputArr[] = { 9, 8, 7, 4, 5, 3, 1, 6 }; int sum = 11;
 * <p>
 * sorting -> O(nlogn) + O(logn)
 */
public class Solution {

    public static int sol(int[] arr, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int val : arr) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        for (int val : arr) {
            int diff = sum - val;
            if (map.containsKey(diff)) {
                count += map.get(diff);
            }
        }
        return count / 2;
    }

    public static void main(String[] args) {
        int inputArr[] = {9, 8, 7, 4, 5, 3, 1, 6};
        System.out.println(sol1(inputArr, 11));
    }

    public static int sol1(int[] arr, int sum) {
        Arrays.sort(arr);
        int counter = 0;
        for (int val : arr) {
            int diff = sum - val;
            int index = binarySearch(arr, 0, arr.length, diff);
            if (index != -1) {
                counter++;
            }
        }
        return counter/2;
    }

    public static int binarySearch(int[] arr, int start, int end, int diff) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (arr[mid] == diff) {
            return mid;
        }
        if (diff > arr[mid]) {
            return binarySearch(arr, mid + 1, end, diff);
        } else {
            return binarySearch(arr, start, mid - 1, diff);
        }
    }

}