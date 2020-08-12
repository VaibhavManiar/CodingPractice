package com.practice.array;

public class RotateArray {
    static int[] rotLeft(int[] a, int d) {
        if (d % a.length == 0) {
            return a;
        } else {
            int[] newArr = new int[a.length];
            if (d > a.length) {
                d = d % a.length;
            }
            for (int index = 0; index < newArr.length; index++) {
                int j = d + index;
                if (j >= a.length) {
                    j = j - a.length;
                }
                newArr[index] = a[j];
            }
            return newArr;
        }
    }

    public static void main(String[] args) {
        int[] a = rotLeft(new int[] {1, 2, 3, 4, 5}, 0);
        for (int val : a) {
            System.out.print(val + " ");
        }
    }
}
