package com.practice.dp;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Longest increasing sub-sequence.
 */
public class LIS {

    public static int[] find(int[] arr) {
        System.out.println();
        System.out.print(arr[0]);
        IntStream.range(1, arr.length).forEach(i -> System.out.print(" , " + arr[i]));

        // Create lis helper (dp) array
        int[] lisHelper = new int[arr.length];

        // fill lis helper array with 1.
        Arrays.fill(lisHelper, 1);

        // calculate lis.
        // loop i = 1 -> len
        // loop j = 0 -> i
        // if arr [j] < arr[i] then lisHelper[i] = max(lisHelper[j]+1 , lisHelper[i])
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    lisHelper[i] = Math.max(lisHelper[i], lisHelper[j] + 1);
                }
            }
        }

        System.out.println();
        System.out.print(lisHelper[0]);
        IntStream.range(1, lisHelper.length).forEach(i -> System.out.print(" , " + lisHelper[i]));
        System.out.println();


        int maxLISIndex = findMaxIndex(lisHelper);

        // max number of lis
        final int maxLISCount = lisHelper[maxLISIndex];

        // Backtrack to find the lis
        // back track from maxLISCount to 0.
        int[] lis = new int[maxLISCount];

        //last value of lis is maxLISIndex ---> back track on lis help from maxLISIndex
        lis[lis.length-1] = arr[maxLISIndex];

        int index = lis.length-2;
        while (index >= 0){
            if(arr[maxLISIndex-1] < arr[maxLISIndex]) {
                lis[index] = arr[maxLISIndex-1];
                index--;
            }
            maxLISIndex--;
        }
        return lis;
    }

    private static int findMaxIndex(int[] arr) {
        int maxIndex = 0;
        for (int index = 1; index < arr.length; index++) {
            maxIndex = arr[index] > arr[maxIndex] ? index : maxIndex;
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        int[] lis = find(new int[]{3, 4, -1, 0, 6, 2, 3, 1});
        System.out.print(lis[0]);
        IntStream.range(1,lis.length).forEach(i-> System.out.print(" , " + lis[i]));
        System.out.println();
    }
}
