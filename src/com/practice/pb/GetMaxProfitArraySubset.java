package com.practice.pb;

public class GetMaxProfitArraySubset {

    // 1,  -2,  3,  4,  -1,  7, -8
    private void findSubset(int[] arr) {
        int max = arr[0];
        int start = 0, end = 0;
        for (int i = 1; i < arr.length; i++) {
            if (max < 0) {
                max = 0;
                continue;
            }
            if (max + arr[i] > max) {
                max = max + arr[i];
                end = i;
            } else {
                start = i + 1;
            }
        }

        if (end < start) {
            start = end;
        }

        System.out.println(start);
        System.out.println(end);
    }

    public void findSubset() {
        int[] arr = new int[8];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 4;
        arr[4] = 100;
        arr[5] = 7;
        arr[6] = 8;
        arr[7] = 10;

        findSubset(arr);
    }
}
