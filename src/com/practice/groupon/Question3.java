package com.practice.groupon;

/**
 * Rotate an array
 * input : 1,2,3,4,5,6
 */
public class Question3 {
    private static int[] rotate(int[] arr) {
        int mid = arr.length / 2;
        int index = 0;
        while (index != mid) {
            int temp = arr[index];
            arr[index] = arr[arr.length- (index + 1)];
            arr[arr.length- (index + 1)] = temp;
            index++;
        }
        return arr;
    }

    public static void main(String[] args) {
        rotate(new int[] {1,2,3,4,5,6});
    }
}
