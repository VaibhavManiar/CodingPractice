package com.practice;

import java.util.Arrays;
import java.util.Collections;

public class MergeSortedArray {

    public static int[] merge(int[] arr1, int[] arr2) {

        if(arr1 == null || arr2 == null) {
            throw new RuntimeException("Input array must not be null.");
        }

        int[] newSortedArr = new int[arr1.length + arr2.length];
        int index1 = 0;
        int index2 = 0;
        int index = 0;

        while(index1 < arr1.length && index2 < arr2.length) {
            if(arr1[index1] < arr2[index2]) {
                newSortedArr[index] = arr1[index1];
                index1++;
            } else {
                newSortedArr[index] = arr2[index2];
                index2++;
            }
            index++;
        }

        while(index1 < arr1.length) {
            newSortedArr[index++] = arr1[index1++];
        }

        while(index2 < arr2.length) {
            newSortedArr[index++] = arr1[index2++];
        }

        return newSortedArr;
    }

    public static void main(String[] args) {
        /*for(int v : merge(new int[]{1, 4, 9}, new int[]{2, 3, 7})) {
            System.out.println(v);
        }*/

        for(int v : merge(new int[]{1, 9, 4}, new int[]{2, 3, 7})) {
            System.out.println(v);
        }
    }




}
