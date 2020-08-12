package com.practice.array;

import java.util.Arrays;

public class Solution {
    public static double findMedianSortedArrays(int[] num1, int[] num2) {
        int len = ((num1.length + num2.length) / 2) + 1;
        int[] arr = new int[len];
        int num1Index = 0;
        int num2Index = 0;
        for (int index = 0; index < arr.length; index++) {
            if (num1Index < num1.length && num2Index < num2.length) {
                if (num1[num1Index] < num2[num2Index]) {
                    arr[index] = num1[num1Index];
                    num1Index++;
                } else {
                    arr[index] = num2[num2Index];
                    num2Index++;
                }
            } else {
                if (num1Index < num1.length) {
                    arr[index] = num1[num1Index];
                    num1Index++;
                } else {
                    arr[index] = num2[num2Index];
                    num2Index++;
                }
            }
        }
        if ((num1.length + num2.length) % 2 == 0) {
            return (double) (arr[arr.length - 1] + arr[arr.length - 2]) / 2;
        } else {
            return arr[arr.length - 1];
        }
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{-2, -1, 0, 1};
        int[] num2 = new int[]{};
        System.out.println(num1);
        System.out.println(num2);
        Arrays.stream(num1).forEach(i-> System.out.print(i + " , "));
        System.out.println();
        Arrays.stream(num2).forEach(i-> System.out.print(i + " , "));
        System.out.println();
        System.out.println(findMedianSortedArrays(num1, num2));
    }
}