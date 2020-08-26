package com.practice.array;

public class FindFirstMissingNumberInSequentialArray {
    public static int find1(int[] arr) {
        int sum = 0;
        for (int index = 1; index <= arr.length; index++) {
            sum += index;
        }

        for (int a : arr) {
            if (a > 0)
                sum -= a;
        }
        return sum;
    }

    private static void testCase1() {
        System.out.println(find1(new int[] {3,4,-1,1}));
    }

    private static void testCase2() {
        System.out.println(find1(new int[] {0,1,2,4}));
    }

    public static void main(String[] args) {
        testCase1();
        testCase2();
    }
}
