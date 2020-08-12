package com.practice.pb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindRotationalPointInAnArray {

    public void rotationalIndex(int[] arr, int start, int end) {
        if(end > start && end-start ==2) {
            System.out.println(findMinIndex(arr, start, end));
            return;
        }

        if (arr[end / 2] > arr[end]) {
            start = start + (end-start)/2;
        } else {
            end = end/2;
        }
        rotationalIndex(arr, start, end);
    }

    public void findInRotationalArray(int[] arr, int start, int end, int val) {
        if(arr[end/2]  == val) {
            System.out.println("Found at index = " + end/2);
            return;
        }

        if(arr[end/2] > val && arr[start] < val) {
            end= end/2;
        } else {
            start = start + (end-start)/2;
        }
        findInRotationalArray(arr, start, end, val);
    }

    private int findMinIndex(int[] arr, int a, int b) {
        return arr[a] < arr[b] ? a : b;
    }
}
