package com.practice.microsoft;

/**
 * Merge sort
 */
public class Question6 {

    public static void main(String[] args) {
        int[] a = new int[]{5, 2, 6, 1, 3, 4};
        mergeSort(a, 0, a.length);
    }

    public static void mergeSort(int[] arr, int s, int e) {
        if (s < e) {
            int m = (s + (e - 1)) / 2;
            mergeSort(arr, s, m);
            mergeSort(arr, m + 1, e);
            merge(arr, s, m, e);
        }
    }

    private static void merge(int[] arr, int s, int m, int e) {
        int[] left = new int[m - s];
        int[] right = new int[e - s];

        System.arraycopy(arr, 0 + s, left, 0, left.length);
        System.arraycopy(arr, 0 + m + 1, right, 0, right.length);

        int i = 0;
        int j = 0;
        int k = s;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < left.length) {
            arr[k++] = left[i++];
        }

        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }
}
