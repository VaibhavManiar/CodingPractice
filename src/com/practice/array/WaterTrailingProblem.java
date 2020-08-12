package com.practice.array;

public class WaterTrailingProblem {
    public static int sol1(int[] arr) {
        int len = arr.length;
        int leftMax = 0;
        int rightMax = 0;
        int low = 0;
        int high = len - 1;
        int result = 0;
        while (low < high) {
            if(arr[low] < arr[high]) {
                if(arr[low] > leftMax) {
                    leftMax = arr[low];
                } else {
                    result += leftMax - arr[low];
                }
                low++;
            } else {
                if(arr[high] > rightMax) {
                    rightMax = arr[high];
                } else {
                    result += rightMax - arr[high];
                }
                high--;
            }
        }
        return result;
    }

    public static int sol2(int[] arr) {
        final int len = arr.length;
        int[] left = new int[len];
        int[] right = new int[len];
        int result = 0;

        left[0] = arr[0];
        for(int index = 1; index < len; index++) {
            left[index] = Math.max(left[index-1], arr[index]);
        }

        right[len-1] = arr[len-1];
        for(int index = len-2; index >= 0; index--) {
            right[index] = Math.max(right[index+1], arr[index]);
        }

        for(int index = 0; index < len; index++) {
            result += Math.min(left[index], right[index]) - arr[index];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(sol1(arr));
        System.out.println(sol2(arr));
    }
}
