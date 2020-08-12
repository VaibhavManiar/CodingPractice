package com.practice.array;

public class CalculateProduct {
    public static int[] calculate(int[] arr) {
        final int n = arr.length;

        int tempValue = 1;
        int[] productArray = new int[n];

        // Assign values to 1.
        for (int index = 0; index < n; index++) {
            productArray[index] = 1;
        }

        // Save intermediate stage value.
        for (int index = 0; index < n; index++) {
            productArray[index] *= tempValue;
            tempValue *= arr[index];
        }

        tempValue = 1;

        // calculate final value.
        for (int index = n - 1; index >= 0; index--) {
            productArray[index] *= tempValue;
            tempValue *= arr[index];
        }

        return productArray;
    }

    public static int[] calculate1(int[] arr) {
        final int len = arr.length;
        final int[] left = new int[len];
        final int[] right = new int[len];
        final int[] result = new int[len];

        left[0] = 1;
        right[len - 1] = 1;


        for (int index = 1; index < len; index++) {
            left[index] = arr[index - 1] * left[index - 1];
        }

        for (int index = len - 2; index >= 0; index--) {
            right[index] = arr[index + 1] * right[index + 1];
        }

        for (int index = 0; index < len; index++) {
            result[index] = left[index] * right[index];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] prod = calculate(new int[]{1, 2, 3, 4, 5});
        for (int val : prod) {
            System.out.println(val);
        }

        int[] prod1 = calculate1(new int[]{1, 2, 3, 4, 5});
        for (int val : prod1) {
            System.out.println(val);
        }
    }
}
