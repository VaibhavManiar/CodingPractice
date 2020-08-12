package com.practice.paytm;

public class FindInCircularSortedArray {

    public static boolean find(int[] arr, int V) {
        return find(arr, 0, arr.length - 1, V);
    }

    public static boolean find(int[] arr, int start, int end, int V) {
        if (start < 0 || end >= arr.length) {
            return Boolean.FALSE;
        }
        if (start > end) {
            return Boolean.FALSE;
        }
        int mid = (start + end) / 2;
        if (arr[mid] == V) {
            return Boolean.TRUE;
        }
        if (arr[start] <= arr[mid]) {
            if (V >= arr[start] && V <= arr[mid]) {
                return find(arr, start, mid - 1, V);
            }
            return find(arr, mid + 1, end, V);
        }
        if (V >= arr[mid] && V <= arr[end]) {
            return find(arr, mid + 1, end, V);
        }
        return find(arr, start, mid - 1, V);
    }

    public static void main(String[] args) {
        System.out.println(find(new int[]{7, 8, 9, 0, 1, 2, 3, 4, 5, 6}, 0));
    }
}