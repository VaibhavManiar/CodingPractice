package com.practice.walmart;

import java.util.*;
import java.util.stream.Collectors;

public class Q1 {

    public static void main(String[] args) {
        System.out.println(coPrime(new int[] {11, 7, 25}));
        System.out.println(coPrime(new int[] {}));
        System.out.println(coPrime(new int[] {11}));
    }

    public static int coPrime(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }

        if(nums.length == 1) {
            return nums[0]  + 1;
        }

        List<List<Integer>> lists = new ArrayList<>();
        int minSize = Integer.MAX_VALUE;
        int minSizeListIndex = 0;
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            List<Integer> l = getCoPrimes(num);
            if(minSize > l.size()) {
                minSize = l.size();
                minSizeListIndex = i;
            }
            lists.add(l);
        }

        int l = getCommonValue(lists, minSizeListIndex);


        if(l < 0) {
            return Collections.max(Arrays.stream(nums).boxed().collect(Collectors.toList()))  + 1;
        }

        return l;
    }

    private static Integer getCommonValue(List<List<Integer>> lists, int minSizeListIndex) {
        List<Integer> l = lists.get(minSizeListIndex);
        for (Integer val : l) {
            int index = 0;
            boolean contains = false;
            while (index < lists.size()) {
                if (index != minSizeListIndex) {
                    if (!lists.get(index).contains(val)) {
                        contains = false;
                        break;
                    } else {
                        contains = true;
                    }
                }
                index++;
            }
            if (contains) {
                return val;
            }
        }
        return -1;
    }

    private static List<Integer> getCoPrimes(int num) {
        List<Integer> set = new ArrayList<>();
        for(int i = 2; i< num; i++) {
            if(isPrimeNumber(num, i)) {
                set.add(i);
            }
        }
        return set;
    }

    private static  boolean isPrimeNumber(int a, int b) {
        if(a == 0 || b == 0) {
            return false;
        }

        if(a == b) {
            return true;
        }

        if(a > b) {
            return isPrimeNumber(a-b, b);
        }

        return isPrimeNumber(a, b-a);
    }
}


