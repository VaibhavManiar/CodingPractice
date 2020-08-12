package com.practice.groupon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * input : 1,2,3,4,-1
 */
public class FindPairsOfGivenSum {
    private static int findCount(int[] arr, int sum) {
        if (arr.length > 0) {
            Map<Integer, Integer> map = new HashMap<>();
            Arrays.stream(arr).forEach(i -> map.put(i, map.getOrDefault(i, 0) + 1));
            int count = 0;
            for(Integer i : arr) {
                count += map.getOrDefault(sum - i, 0);
            }
            return count/2;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(findCount(new int[] {1,2,3,4,-1}, 3));
    }

}
