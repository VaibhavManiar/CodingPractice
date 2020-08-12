package com.practice.sort;

import java.util.Collections;

public class MergeSort {
    public static void sort(int[] arr, int left, int right) {
        if(left >= right)
            return;

        int mid = (left + right - 1)/2;
        sort(arr, left, mid);
        sort(arr, mid+1, right);
        merge(arr, left, mid, right);
    }

    private static void merge (int[] arr, int left, int mid, int right) {
        int leftArrLength = (mid - left) + 1; // left to mid
        int rightArrLength = (right - mid); // mid + 1 to right
        int[] leftArr = new int[leftArrLength];
        int[] rightArr = new int[rightArrLength];

        for(int leftIndex = 0; leftIndex < leftArrLength; leftIndex++) {
            leftArr[leftIndex] = arr[left + leftIndex];
        }

        for(int rightIndex = 0; rightIndex < rightArrLength; rightIndex++) {
            rightArr[rightIndex] = arr[(mid + 1) + rightIndex];
        }

        int leftIndex = 0;
        int rightIndex = 0;
        int arrIndex = left;
        while(leftIndex <  leftArrLength && rightIndex < rightArrLength) {
            if(leftArr[leftIndex] < rightArr[rightIndex]) {
                arr[arrIndex] = leftArr[leftIndex];
                leftIndex++;
            } else {
                arr[arrIndex] = rightArr[rightIndex];
                rightIndex++;
            }
            arrIndex++;
        }

        while(leftIndex <  leftArrLength) {
            arr[arrIndex] = leftArr[leftIndex];
            leftIndex++;
            arrIndex++;
        }

        while(rightIndex <  rightArrLength) {
            arr[arrIndex] = rightArr[rightIndex];
            rightIndex++;
            arrIndex++;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,4,3,2,1,2,3,4,5};
        sort(arr, 0, arr.length-1);
        for(int a : arr) {
            System.out.println(a);
        }
    }


}
