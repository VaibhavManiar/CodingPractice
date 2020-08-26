package com.practice.array;


import java.util.*;

public class ZeroSumTriplets {

    private static Map<Integer, List<Integer>> cache(int[] arr) {
        Map<Integer, List<Integer>> cache = new HashMap<>();
        for (int index = 0; index < arr.length; index++) {
            if(!cache.containsKey(arr[index])) {
                List<Integer> list = new ArrayList<>();
                list.add(index);
                cache.put(arr[index], list);
            } else {
                cache.get(arr[index]).add(index);
            }
        }
        return cache;
    }

    public static List<Triplet> getZeroSumTriplets(int[] arr) {
        Map<Integer, List<Integer>> cache = cache(arr);
        List<Triplet> triplets = new ArrayList<>();
        for (int index1 = 0; index1 < arr.length; index1++) {
            for (int index2 = 0; index2 < arr.length; index2++) {
                if (index1 != index2) {
                    int negativeSum = (arr[index1] + arr[index2]) * -1;
                    if (cache.containsKey(negativeSum)) {
                        List<Integer> indexes = cache.get(negativeSum);
                        for(Integer index3 : indexes) {
                            triplets.add(new Triplet(index1, index2, index3));
                        }
                    }
                }
            }
        }
        return triplets;
    }

    static class Triplet {
        final int index1;
        final int index2;
        final int index3;

        public Triplet(int index1, int index2, int index3) {
            this.index1 = index1;
            this.index2 = index2;
            this.index3 = index3;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Triplet)) return false;
            Triplet triplet = (Triplet) o;
            return index1 == triplet.index1 &&
                    index2 == triplet.index2 &&
                    index3 == triplet.index3;
        }

        @Override
        public int hashCode() {
            return Objects.hash(index1, index2, index3);
        }
    }

    public static void main(String[] args) {

    }

}