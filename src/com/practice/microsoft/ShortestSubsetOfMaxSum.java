package com.practice.microsoft;

import java.util.Map;

public class ShortestSubsetOfMaxSum {
    public static void find(int[] arr) {
        int max = 0;
        int sum = 0;
        int actualStartIndex = 0;
        int actualEndIndex = 0;

        int currStartIndex = 0;
        int currEndIndex = 0;
        for (int index = 0; index < arr.length; index++) {
            sum += arr[index];
            if(sum > max) {
                max = sum;
                currEndIndex = index;
            } else {
                sum = 0;
                actualStartIndex =
                currStartIndex = index +1;
                currEndIndex = currStartIndex;
            }
        }
    }
}
